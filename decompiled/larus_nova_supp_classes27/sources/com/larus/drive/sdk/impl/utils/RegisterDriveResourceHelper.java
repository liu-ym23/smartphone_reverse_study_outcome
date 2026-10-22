package com.larus.drive.sdk.impl.utils;

import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.platform.model.upload.FlowResourceType;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class RegisterDriveResourceHelper {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveFileType.values().length];
            r0[DriveFileType.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DriveFileType.AUDIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static void a(DriveFileItem r12, CoroutineScope r13, Function1 r14, Function0 r15) {
        Intrinsics.checkNotNullParameter(r12, "item");
        Intrinsics.checkNotNullParameter(r13, "scope");
        if (CollectionsKt.listOf(new DriveFileType[]{DriveFileType.AUDIO, DriveFileType.VIDEO}).contains(r12.j) == true) goto L6;
        r14.invoke(null);
        return;
    L6:
        Ref.IntRef r8 = new Ref.IntRef();
        r8.element = FlowResourceType.Unknown.getValue();
        int r1 = a.a[r12.j.ordinal()];
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L11;
        r14.invoke(null);
        return;
    L11:
        r8.element = FlowResourceType.Audio.getValue();
        String r0 = "5";
    L13:
        BuildersKt.launch$default(r13, Dispatchers.getIO(), null, new RegisterDriveResourceHelper$registerDriveResource$1(r13, r0, r12, r8, r15, r14, null), 2, null);
        return;
    L12:
        r8.element = FlowResourceType.Video.getValue();
        r0 = "21";
        goto L13
    }
}
