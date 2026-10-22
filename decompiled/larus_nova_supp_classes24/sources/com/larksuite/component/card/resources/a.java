package com.larksuite.component.card.resources;

import android.content.Context;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import com.suite.lark.platform.component.storage.file.dirs.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final HashMap<CardResource.ResourceType, String> a = null;

    /* JADX INFO: renamed from: com.larksuite.component.card.resources.a$a, reason: collision with other inner class name */
    public static final class C0028a implements UniPathProvider {

        /* JADX INFO: renamed from: com.larksuite.component.card.resources.a$a$a, reason: collision with other inner class name */
        public static final class C0029a {
        }

        /* JADX INFO: renamed from: com.larksuite.component.card.resources.a$a$b */
        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[UniPathProvider.SpaceType.values().length];
                r0[UniPathProvider.SpaceType.LARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[UniPathProvider.SpaceType.USER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        static {
        }

        public C0028a() {
        }

        public final FileStorage b() {
            UniPathProvider.SpaceType r0 = UniPathProvider.SpaceType.USER;
            int r1 = b.a[r0.ordinal()];
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L8;
            return LarkFileStorage.c();
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return LarkFileStorage.b();
        }

        public final UniPathProvider.SpaceType c() {
            return UniPathProvider.SpaceType.USER;
        }

        public final String a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public final VFSPath d(FileStorage r5) {
            Intrinsics.checkNotNullParameter(r5, "space");
            return r5.b(f.h, new com.ss.android.lark.storage.d(new String[]{"open_platform", "universalcard"}));
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CardResource.ResourceType.values().length];
            r0[CardResource.ResourceType.AUDIO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CardResource.ResourceType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public a() {
    }

    static {
        CardResource.ResourceType[] r0 = CardResource.ResourceType.values();
        ArrayList r1 = new ArrayList(r0.length);
        int r2 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L13;
        CardResource.ResourceType r5 = r0[r4];
        int r6 = b.a[r5.ordinal()];
        if (r6 != 1) goto L7;
        String r7 = "audio";
    L12:
        int r8 = com.bytedance.ee.lark.infra.file.b.a;
        int r9 = h.c;
        h r10 = h.a.a(LarkContext.getApplication());
        VFSFiles.b.getClass();
        r10.c(VFSFiles.b(true));
        C0028a r11 = new C0028a();
        Intrinsics.checkNotNullParameter(r11, "pathProvider");
        r1.add(TuplesKt.to(r5, r10.a(r11).a().subPath(r7).getRealPath()));
        r4 = r4 + 1;
        goto L3
    L7:
        if (r6 != 2) goto L10;
        r7 = GlobalAudioSceneEnum.VIDEO;
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    L13:
        Pair[] r3 = (Pair[]) r1.toArray(new Pair[0]);
        a = MapsKt.hashMapOf((Pair[]) Arrays.copyOf(r3, r3.length));
    }
}
