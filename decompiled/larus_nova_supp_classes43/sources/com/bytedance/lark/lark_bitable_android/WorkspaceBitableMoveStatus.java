package com.bytedance.lark.lark_bitable_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/WorkspaceBitableMoveStatus;", "", "(Ljava/lang/String;I)V", "into", "Llark_bitable/proto/WorkspaceBitableMoveStatus;", "intoInt", "", "Unsupported", "Success", "Fail", "Nopermission", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum WorkspaceBitableMoveStatus extends Enum<WorkspaceBitableMoveStatus> {
    public static final a Companion = null;
    public static final WorkspaceBitableMoveStatus Fail = null;
    public static final WorkspaceBitableMoveStatus Nopermission = null;
    public static final WorkspaceBitableMoveStatus Success = null;
    public static final WorkspaceBitableMoveStatus Unsupported = null;
    public static final /* synthetic */ WorkspaceBitableMoveStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WorkspaceBitableMoveStatus.values().length];
            r0[WorkspaceBitableMoveStatus.Unsupported.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[WorkspaceBitableMoveStatus.Success.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[WorkspaceBitableMoveStatus.Fail.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[WorkspaceBitableMoveStatus.Nopermission.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static EnumEntries<WorkspaceBitableMoveStatus> getEntries() {
        return b;
    }

    public static WorkspaceBitableMoveStatus valueOf(String r1) {
        return (WorkspaceBitableMoveStatus) r27.a.a(WorkspaceBitableMoveStatus.class, r1);
    }

    public static WorkspaceBitableMoveStatus[] values() {
        return (WorkspaceBitableMoveStatus[]) a.clone();
    }

    static {
        WorkspaceBitableMoveStatus r0 = new WorkspaceBitableMoveStatus("Unsupported", 0);
        Unsupported = r0;
        WorkspaceBitableMoveStatus r1 = new WorkspaceBitableMoveStatus("Success", 1);
        Success = r1;
        WorkspaceBitableMoveStatus r10 = new WorkspaceBitableMoveStatus("Fail", 2);
        Fail = r10;
        WorkspaceBitableMoveStatus r11 = new WorkspaceBitableMoveStatus("Nopermission", 3);
        Nopermission = r11;
        WorkspaceBitableMoveStatus[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
        Companion = new a();
    }

    public final lark_bitable.proto.WorkspaceBitableMoveStatus into() {
        int r0 = b.a[ordinal()];
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L18;
        if (r0 != 4) goto L12;
        return lark_bitable.proto.WorkspaceBitableMoveStatus.VAR_WORKSPACE_BITABLE_MOVE_STATUS_NOPERMISSION;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return lark_bitable.proto.WorkspaceBitableMoveStatus.VAR_WORKSPACE_BITABLE_MOVE_STATUS_FAIL;
    L19:
        return lark_bitable.proto.WorkspaceBitableMoveStatus.VAR_WORKSPACE_BITABLE_MOVE_STATUS_SUCCESS;
    L16:
        return lark_bitable.proto.WorkspaceBitableMoveStatus.VAR_WORKSPACE_BITABLE_MOVE_STATUS_UNSUPPORTED;
    }

    public final int intoInt() {
        int r0 = b.a[ordinal()];
        if (r0 != 1) goto L5;
        return 0;
    L5:
        if (r0 != 2) goto L7;
        return 1;
    L7:
        if (r0 != 3) goto L9;
        return 2;
    L9:
        if (r0 != 4) goto L12;
        return 3;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final WorkspaceBitableMoveStatus fromInt(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 != 3) goto L12;
        return Nopermission;
    L12:
        throw new RuntimeException("Unmatched primitive enum value: WorkspaceBitableMoveStatus with ");
    L18:
        return Fail;
    L19:
        return Success;
    L16:
        return Unsupported;
    }

    public WorkspaceBitableMoveStatus(String r1, int r10) {
        super(r1, r10);
    }
}
