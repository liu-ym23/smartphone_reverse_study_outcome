package com.larus.drive.biz.impl.file;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.utils.logger.FLogger;
import hq9.c2;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveOfficeUploadGuard {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/drive/biz/impl/file/DriveOfficeUploadGuard$BlockReason;", "", "<init>", "(Ljava/lang/String;I)V", "UPLOAD_QUEUE_FULL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BlockReason extends Enum<BlockReason> {
        public static final BlockReason UPLOAD_QUEUE_FULL = null;
        public static final /* synthetic */ BlockReason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<BlockReason> getEntries() {
            return b;
        }

        static {
            BlockReason r0 = new BlockReason();
            UPLOAD_QUEUE_FULL = r0;
            BlockReason[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public BlockReason() {
            super("UPLOAD_QUEUE_FULL", 0);
        }

        public static BlockReason[] values() {
            return (BlockReason[]) a.clone();
        }

        public static BlockReason valueOf(String r1) {
            return (BlockReason) r27.a.a(BlockReason.class, r1);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BlockReason.values().length];
            r0[BlockReason.UPLOAD_QUEUE_FULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    public static String c(Fragment r8, BlockReason r9) {
        boolean r1 = true;
        if (a.a[r9.ordinal()] != 1) goto L17;
        String r2 = r8.getString(2131907892);     // Catch: Exception -> L14
        Lazy r0 = t.a;     // Catch: Exception -> L14
        String r3 = StringsKt.replace$default(r2, "%s", String.valueOf(((c2) t.b.getValue()).j()), false, 4, null);     // Catch: Exception -> L14
        if (r8.isAdded() == true) goto L7;
    L11:
        r1 = false;
    L12:
        if (r1 == false) goto L21;
        t19.s r4 = t19.s.a;     // Catch: Exception -> L14
        FragmentActivity r10 = r8.getActivity();     // Catch: Exception -> L14
        r4.getClass();     // Catch: Exception -> L14
        t19.s.t(r10, r3);     // Catch: Exception -> L14
        return r3;
    L21:
        return r3;
    L7:
        if (r8.isStateSaved() == true) goto L11;
        if (r8.getActivity() == null) goto L11;
    L17:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        FLogger.a.e("DriveOfficeUploadGuard", "show office upload block toast failed, reason=" + r9, e);
        return r9.name();
    }

    public static void a(Fragment r7, Function0 r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r7, "fragment");
        Intrinsics.checkNotNullParameter(r8, "onPassed");
        Intrinsics.checkNotNullParameter(r9, "onBlocked");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r7), null, null, new DriveOfficeUploadGuard$checkBeforeOpenPicker$1(r7, r9, r8, null), 3, null);
    }

    public static List b(Fragment r2, List r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "selections");
        Intrinsics.checkNotNullParameter(r4, "onBlocked");
        int r0 = r3.size();
        if (r0 <= 0) goto L5;
        boolean r1 = t.h(r0);
    L10:
        if (r1 == true) goto L12;
        BlockReason r5 = BlockReason.UPLOAD_QUEUE_FULL;
    L13:
        if (r5 == null) goto L16;
        r4.invoke(c(r2, BlockReason.UPLOAD_QUEUE_FULL));
        return null;
    L16:
        return r3;
    L12:
        r5 = null;
        goto L13
    L5:
        if (t.i() == true) goto L7;
        r1 = true;
        goto L10
    L7:
        r1 = false;
        goto L10
    }
}
