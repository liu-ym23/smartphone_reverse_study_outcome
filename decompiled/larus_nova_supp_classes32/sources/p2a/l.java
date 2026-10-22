package p2a;

import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.audio.bean.RecommendScene;
import com.larus.voice_setting.UgcVoiceRecommendScene;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RecommendScene.values().length];
            r0[RecommendScene.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L57:
            r0[RecommendScene.BOT_FIRST_MET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L65:
            r0[RecommendScene.REAL_TIME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L41:
            r0[RecommendScene.CHAT_SETTING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L43:
            r0[RecommendScene.BOT_CREATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L51:
            r0[RecommendScene.BOT_UPDATE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L59:
            r0[RecommendScene.ROUTER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L16:
            a = r0;
            int[] r1 = new int[UgcVoiceRecommendScene.values().length];
            r1[UgcVoiceRecommendScene.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L55:
            r1[UgcVoiceRecommendScene.BOT_FIRST_MET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L63:
            r1[UgcVoiceRecommendScene.REAL_TIME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L39:
            r1[UgcVoiceRecommendScene.CHAT_SETTING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L45:
            r1[UgcVoiceRecommendScene.BOT_CREATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L53:
            r1[UgcVoiceRecommendScene.BOT_UPDATE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L61:
            r1[UgcVoiceRecommendScene.ROUTER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L38
            return;
        }
    }

    public static final k a(GetMatchVoiceRequest r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        String r2 = r11.a;
        String r3 = r11.b;
        String r4 = r11.c;
        String r5 = r11.d;
        long r6 = r11.e;
        String r8 = r11.f;
        RecommendScene r12 = r11.g;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        switch(a.a[r12.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        UgcVoiceRecommendScene r13 = UgcVoiceRecommendScene.ROUTER;
    L14:
        return new k(r2, r3, r4, r5, r6, r8, r13);
    L7:
        r13 = UgcVoiceRecommendScene.BOT_UPDATE;
        goto L14
    L8:
        r13 = UgcVoiceRecommendScene.BOT_CREATE;
        goto L14
    L9:
        r13 = UgcVoiceRecommendScene.CHAT_SETTING;
        goto L14
    L10:
        r13 = UgcVoiceRecommendScene.REAL_TIME;
        goto L14
    L11:
        r13 = UgcVoiceRecommendScene.BOT_FIRST_MET;
        goto L14
    L12:
        r13 = UgcVoiceRecommendScene.NULL;
        goto L14
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
