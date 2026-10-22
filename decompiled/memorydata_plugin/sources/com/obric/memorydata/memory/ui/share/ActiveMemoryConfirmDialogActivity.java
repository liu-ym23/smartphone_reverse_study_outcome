package com.obric.memorydata.memory.ui.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.constants.Constants;
import com.obric.memorydata.memory.v;
import com.obric.memorydata.plugin.R;
import com.obric.oui.dialog.v2.alert.b;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/share/ActiveMemoryConfirmDialogActivity;", "Landroid/app/Activity;", "<init>", "()V", "handled", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showConfirmDialog", "onDestroy", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ActiveMemoryConfirmDialogActivity extends GeneratePluginActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11522b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/share/ActiveMemoryConfirmDialogActivity$Companion;", "", "<init>", "()V", Constants.LAUNCH_TAG, "", "context", "Landroid/content/Context;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intent r4 = new Intent(r2, ActiveMemoryConfirmDialogActivity.class);
            if (ZeusTransformUtils.instanceOf(r2, Activity.class) == true) goto L5;
            r4.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L5:
            ZeusTransformUtils.startActivity(r2, r4, "com.obric.memorydata.plugin");
        }
    }

    static {
        f11521a = new a(null);
    }

    public ActiveMemoryConfirmDialogActivity() {
    }

    private static final Unit a(ActiveMemoryConfirmDialogActivity r1, DialogInterface r2, int r3) {
        ActiveMemoryConfirmDialogActivity r4 = (ActiveMemoryConfirmDialogActivity) ZeusTransformUtils.wrapperContextForParams(r1, ActiveMemoryConfirmDialogActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "dialog");
        r4.f11522b = true;
        v.f11572a.c();
        r5.dismiss();
        r4.finish();
        return Unit.INSTANCE;
    }

    private final void a() {
        com.obric.oui.dialog.v2.alert.a r0 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(b.a(new b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).b(false).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.active_memory_confirm_dialog_title, TypedValues.Custom.S_STRING, "active_memory_confirm_dialog_title")), CharSequence.class, "com.obric.memorydata.plugin"), false), false, 1, null).b(ZeusTransformUtils.mapRes(R.string.active_memory_confirm_dialog_cancel, TypedValues.Custom.S_STRING, "active_memory_confirm_dialog_cancel"), new $$Lambda$ActiveMemoryConfirmDialogActivity$_jLfBUUMu7RXvK8XO3tZg89v8(this)).a(ZeusTransformUtils.mapRes(R.string.active_memory_confirm_dialog_confirm, TypedValues.Custom.S_STRING, "active_memory_confirm_dialog_confirm"), new $$Lambda$ActiveMemoryConfirmDialogActivity$cgZfUDBjW7oY17Jv1YEKgaATrI(this)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r0.setOnDismissListener(new $$Lambda$ActiveMemoryConfirmDialogActivity$OWw1oC7_2ZsZpAskIkTrGj32m4(this));
        r0.show();
    }

    private static final void a(ActiveMemoryConfirmDialogActivity r2, DialogInterface r3) {
        ActiveMemoryConfirmDialogActivity r4 = (ActiveMemoryConfirmDialogActivity) ZeusTransformUtils.wrapperContextForParams(r2, ActiveMemoryConfirmDialogActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        if (r4.f11522b == true) goto L6;
        v.f11572a.c();
        r4.finish();
        return;
    }

    private static final Unit b(ActiveMemoryConfirmDialogActivity r1, DialogInterface r2, int r3) {
        ActiveMemoryConfirmDialogActivity r4 = (ActiveMemoryConfirmDialogActivity) ZeusTransformUtils.wrapperContextForParams(r1, ActiveMemoryConfirmDialogActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "dialog");
        r4.f11522b = true;
        v.f11572a.b();
        r5.dismiss();
        r4.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$OWw1oC7_2-ZsZpAskIkTrGj32m4, reason: not valid java name */
    public static /* synthetic */ void m990lambda$OWw1oC7_2ZsZpAskIkTrGj32m4(ActiveMemoryConfirmDialogActivity r0, DialogInterface r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$_jLfBUUMu7RX-vK8XO3tZg89-v8, reason: not valid java name */
    public static /* synthetic */ Unit m991lambda$_jLfBUUMu7RXvK8XO3tZg89v8(ActiveMemoryConfirmDialogActivity r0, DialogInterface r1, int r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$cgZfUDBjW7-oY17Jv1YEKgaATrI, reason: not valid java name */
    public static /* synthetic */ Unit m992lambda$cgZfUDBjW7oY17Jv1YEKgaATrI(ActiveMemoryConfirmDialogActivity r0, DialogInterface r1, int r2) {
        return b(r0, r1, r2);
    }

    public String getPluginPkgName() {
        return "com.obric.memorydata.plugin";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r1) {
        super/*android.app.Activity*/.onCreate(r1);
        a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        if (this.f11522b == true) goto L5;
        v.f11572a.c();
    L5:
        super/*android.app.Activity*/.onDestroy();
    }
}
