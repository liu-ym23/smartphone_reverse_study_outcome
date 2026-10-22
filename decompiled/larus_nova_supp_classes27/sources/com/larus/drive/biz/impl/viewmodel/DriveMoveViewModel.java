package com.larus.drive.biz.impl.viewmodel;

import android.content.Context;
import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J>\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/drive/biz/impl/viewmodel/DriveMoveViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_selectedFolder", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/drive/biz/api/model/DriveMoveSelectedFolder;", "selectedFolder", "Landroidx/lifecycle/LiveData;", "getSelectedFolder", "()Landroidx/lifecycle/LiveData;", "selectFolder", "", "folder", "handleMoveFile", "context", "Landroid/content/Context;", "fileToken", "", "driveObjType", "", "parentFolderToken", "parentFolderDriveToken", "refreshMark", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMoveViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DriveMoveViewModel";
    private final MutableLiveData<i79.a> _selectedFolder;
    private final LiveData<i79.a> selectedFolder;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit Mo(Context r0, String r1, String r2) {
        return handleMoveFile$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit yo(Context r0, String r1) {
        return handleMoveFile$lambda$1(r0, r1);
    }

    public DriveMoveViewModel() {
        MutableLiveData<i79.a> r0 = new MutableLiveData();
        this._selectedFolder = r0;
        this.selectedFolder = r0;
    }

    public final LiveData<i79.a> getSelectedFolder() {
        return this.selectedFolder;
    }

    public final void selectFolder(i79.a r2) {
        Intrinsics.checkNotNullParameter(r2, "folder");
        this._selectedFolder.setValue(r2);
    }

    private static final Unit handleMoveFile$lambda$1(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.i(TAG, "moveFile error: " + r4);
        if (Intrinsics.areEqual(r4, "error_message_drive_update") == false) goto L5;
        int r5 = 2131905388;
    L6:
        t19.s r0 = t19.s.a;
        String r6 = r3.getString(r5);
        r0.getClass();
        t19.s.t(r3, r6);
        return Unit.INSTANCE;
    L5:
        r5 = 2131905391;
        goto L6
    }

    private static final Unit handleMoveFile$lambda$0(Context r2, String r3, String r4) {
        t19.s r0 = t19.s.a;
        String r1 = r2.getString(2131905390);
        r0.getClass();
        t19.s.p(r2, r1);
        MutableLiveData<com.larus.drive.biz.impl.utils.d> r5 = com.larus.drive.biz.impl.utils.c.a;
        long r6 = SystemClock.elapsedRealtime();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        com.larus.drive.biz.impl.utils.d r7 = new com.larus.drive.biz.impl.utils.d(r6, r3, r4);
        com.larus.drive.biz.impl.utils.c.a.setValue(r7);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.drive.biz.impl.viewmodel.z] */
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
    public final void handleMoveFile(final Context r7, String r8, int r9, final String r10, String r11, final String r12) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r8 != null) goto L5;
        return;
    L5:
        DriveSdkService.a.u(r8, r9, r10, new z(r7, r12, r10), new a0(r7));
    }
}
