package ar9;

import com.larus.platform.model.music.ThirdPartyMusicPlatform;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ThirdPartyMusicPlatform.values().length];
            r0[ThirdPartyMusicPlatform.QQMusicType.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ThirdPartyMusicPlatform.LunaMusicType.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ThirdPartyMusicPlatform.Other.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ThirdPartyMusicPlatform.NetEaseMusicType.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final String a(List<? extends ThirdPartyMusicPlatform> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, new ar9.a(), 30, null);
    }

    public static final String b(ThirdPartyMusicPlatform r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "qq";
    L5:
        if (r2 != 2) goto L7;
        return "soda";
    L7:
        if (r2 != 3) goto L9;
        return "other";
    L9:
        if (r2 == 4) goto L11;
        return "";
    L11:
        return "neteasemusic";
    }
}
