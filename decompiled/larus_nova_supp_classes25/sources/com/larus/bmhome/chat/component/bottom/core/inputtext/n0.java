package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.R;
import android.os.Build;
import android.text.Editable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.larus.common.apphost.AppHost;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n0 {

    public static final class a implements ActionMode.Callback {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ Function0<Boolean> b;
        public final /* synthetic */ Function0<Unit> c;
        public final /* synthetic */ Function0<Boolean> d;

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r1, Menu r2) {
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r1) {
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r5, MenuItem r6) {
            boolean r0 = true;
            if (r6 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == false) goto L15;
            Function0<Unit> r7 = this.c;
            if (r7 == null) goto L12;
            r7.invoke();
        L12:
            if (r5 == null) goto L14;
            r5.finish();
        L14:
            return true;
        L15:
            if (r6 != null) goto L17;
        L19:
            boolean r3 = false;
        L20:
            if (r3 == true) goto L27;
            if (r6 != null) goto L23;
        L25:
            boolean r4 = false;
        L26:
            if (r4 == true) goto L27;
        L37:
            if (r6 != null) goto L39;
        L41:
            r0 = false;
        L42:
            if (r0 == true) goto L45;
            if (r5 == null) goto L45;
            r5.finish();
        L45:
            return false;
        L39:
            if (r6.getItemId() != 16908319) goto L41;
        L23:
            if (r6.getItemId() != 16908337) goto L25;
            r4 = true;
        L27:
            Function0<Boolean> r8 = this.d;
            if (r8 != null) goto L30;
        L32:
            boolean r9 = false;
        L33:
            if (r9 == false) goto L37;
            if (r5 == null) goto L36;
            r5.finish();
        L36:
            return true;
        L30:
            if (((Boolean) r8.invoke()).booleanValue() != true) goto L32;
            r9 = true;
            goto L33
        L17:
            if (r6.getItemId() != 16908322) goto L19;
            r3 = true;
            goto L20
        L5:
            if (r6.getItemId() != 1001) goto L7;
            r2 = true;
            goto L8
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r6, Menu r7) {
            Editable r8 = this.a.getText();
            boolean r0 = false;
            if (r8 == null) goto L5;
            int r9 = r8.length();
        L7:
            if (r9 <= 0) goto L9;
        L11:
            boolean r10 = false;
        L12:
            if (r7 != null) goto L15;
            return false;
        L15:
            if (r10 == true) goto L22;
            if (r7.findItem(1001) == null) goto L20;
            r7.removeItem(1001);
            return true;
        L20:
            return false;
        L22:
            if (r7.findItem(1001) == null) goto L24;
            return false;
        L24:
            MenuItem r11 = r7.findItem(R.id.paste);
            if (r11 == null) goto L37;
            int r3 = com.larus.utils.j0.a;
            String r4 = com.larus.utils.j0.d(2131906778);
            r7.add(r11.getGroupId(), 1001, r11.getOrder() + 1, r4);
            IFlowSdkDepend r12 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r12 == null) goto L31;
            r12.d0();
            if (com.larus.home.impl.sdk.i1.a.h(AppHost.a.getApplication(), "bpea-input-long-press") == true) goto L31;
            r0 = true;
        L31:
            if (r0 == false) goto L36;
            int r13 = com.larus.bmhome.chat.outerinput.b0.a;
            by7.e r14 = by7.h.g(this.a);
            by7.a r15 = new by7.a("input_paste_show_with_no_clipboard_content");
            if (r14 == null) goto L35;
            r15.b = r14;
        L35:
            r15.b();
        L36:
            return true;
        L37:
            return false;
        L9:
            if (((Boolean) this.b.invoke()).booleanValue() == false) goto L11;
            r10 = true;
            goto L12
        L5:
            r9 = 0;
            goto L7
        }

        public a(EditText r1, Function0<Boolean> r2, Function0<Unit> r3, Function0<Boolean> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final void a(EditText r2, boolean r3, Function0<Boolean> r4, Function0<Unit> r5, Function0<Boolean> r6, Function1<? super Boolean, Boolean> r7) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "needPasteAndSend");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        o0 r0 = null;
        if (r3 == true) goto L9;
        r2.setCustomInsertionActionModeCallback(null);
        r2.setCustomSelectionActionModeCallback(null);
        return;
    L9:
        if (r6 != null) goto L11;
        if (r7 != null) goto L11;
    L12:
        r2.setCustomSelectionActionModeCallback(r0);
        r2.setCustomInsertionActionModeCallback(new a(r2, r4, r5, r6));
        return;
    L11:
        r0 = new o0(r7, r6);
        goto L12
    }
}
