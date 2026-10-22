package com.obric.aiproactive.ui.preference;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/preference/RuleEditorAlertDialogBuilder;", "Lcom/obric/oui/dialog/v2/alert/OAlertDialogBuilder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "newDialogInstance", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "withHeightMatchParent", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class s extends com.obric.oui.dialog.v2.alert.b {
    public s(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
    }

    @Override // com.obric.oui.dialog.v2.alert.b
    public com.obric.oui.dialog.v2.alert.a a(Context r2, boolean r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        return (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(new r(r1, r3), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
    }
}
