package com.ss.android.lark.keyboard.utils;

import android.text.Editable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements ActionMode.Callback {
    public final /* synthetic */ KeyboardFunctionEditText a;

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r1) {
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r1, Menu r2) {
        return true;
    }

    public e(KeyboardFunctionEditText r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r3, MenuItem r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.getItemId() != 2131376759) goto L14;
        Editable r5 = this.a.getEditableText();
        int r6 = this.a.getSelectionStart();
        int r0 = this.a.getSelectionEnd();
        if ((r0 - r6) <= 0) goto L9;
        r5.delete(r6, r0);
    L9:
        if (r6 >= 0) goto L11;
        r6 = r5.length();
    L11:
        this.a.setSelection(r6);
        r5.insert(r6, "\n");
        return true;
    L14:
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r5, Menu r6) {
        if ((this.a.getSelectionEnd() - this.a.getSelectionStart()) <= 0) goto L5;
        return true;
    L5:
        if (r6 == null) goto L7;
        r6.add(769711401, 2131376759, 0, 2131891377);
    L7:
        return true;
    }
}
