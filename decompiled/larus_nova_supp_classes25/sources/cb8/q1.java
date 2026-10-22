package cb8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverImageEntity;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverItem;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q1 implements kc8.c0 {
    public final /* synthetic */ com.larus.bmhome.chat.api.q0.a a;

    public q1(com.larus.bmhome.chat.api.q0.a r1) {
        this.a = r1;
    }

    @Override // kc8.c0
    public final void a(View r30, Message r31, nr9.g r32, JSONObject r33) {
        Intrinsics.checkNotNullParameter(r30, "view");
        Intrinsics.checkNotNullParameter(r31, "data");
        Intrinsics.checkNotNullParameter(r32, "videoPlayData");
        nr9.f r1 = r32.g;
        IAIChatUgcAIGCService.Companion r2 = IAIChatUgcAIGCService.a;
        com.larus.bmhome.chat.api.q0.a r6 = this.a;
        String r10 = r32.a;
        String r7 = null;
        if (r1 == null) goto L5;
        Integer r11 = r1.e;
    L6:
        if (r1 == null) goto L8;
        Integer r12 = r1.d;
    L10:
        if (r1 == null) goto L15;
        String r14 = r1.b;
        if (r14 == null) goto L15;
    L14:
        String r15 = r14;
    L19:
        if (r1 == null) goto L23;
        Integer r16 = r1.e;
        if (r16 == null) goto L23;
        int r17 = r16.intValue();
    L24:
        if (r1 == null) goto L28;
        Integer r18 = r1.d;
        if (r18 == null) goto L28;
        int r19 = r18.intValue();
    L29:
        CoverImageEntity r9 = new CoverImageEntity(r15, null, r17, r19, 2, null);
        if (r1 == null) goto L35;
        String r110 = r1.a;
        if (r110 == null) goto L35;
        String r23 = r110;
    L39:
        if (r1 == null) goto L43;
        Integer r8 = r1.e;
        if (r8 == null) goto L43;
        int r25 = r8.intValue();
    L44:
        if (r1 == null) goto L48;
        Integer r3 = r1.d;
        if (r3 == null) goto L48;
        int r26 = r3.intValue();
    L49:
        r2.T(r30, r31, new AiGenVideoContentData(r10, r11, r12, null, new CoverItem(null, new CoverImageEntity(r23, null, r25, r26, 2, null), r9, null, 9, null), r32.b, r32.h, r32.c, r32.d, r32.e, r32.f, null, null, 6152, null), r6, r33);
        return;
    L48:
        r26 = 0;
    L43:
        r25 = 0;
    L35:
        if (r1 == null) goto L37;
        r7 = r1.c;
    L37:
        r23 = r7;
    L28:
        r19 = 0;
    L23:
        r17 = 0;
    L15:
        if (r1 == null) goto L17;
        r14 = r1.c;
        goto L14
    L17:
        r15 = null;
        goto L19
    L8:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    @Override // kc8.c0
    public final void d(View r8, Message r9, AiGenVideoContentData r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "data");
        IAIChatUgcAIGCService.a.T(r8, r9, r10, this.a, r11);
    }

    @Override // kc8.c0
    public final void c(View r9, Message r10, df8.a r11, ViewGroup r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "data");
        IAIChatUgcAIGCService.a.a(IAIChatUgcAIGCService.a, r9, r10, this.a, r11, r12, r13);
    }

    @Override // kc8.c0
    public final void b(View r24, Message r25, kc8.f0 r26, int r27, ViewGroup r28, JSONObject r29) {
        Intrinsics.checkNotNullParameter(r24, "view");
        Intrinsics.checkNotNullParameter(r25, "data");
        Intrinsics.checkNotNullParameter(r26, "imageInfo");
        IAIChatUgcAIGCService.Companion r2 = IAIChatUgcAIGCService.a;
        com.larus.bmhome.chat.api.q0.a r5 = this.a;
        String r7 = r26.a;
        String r8 = r26.b;
        kc8.g0 r6 = r26.d;
        if (r6 == null) goto L5;
        ImageEntity r9 = new ImageEntity(r6.a, r6.b, r6.c, r6.d, null, 16, null);
    L6:
        kc8.g0 r10 = r26.c;
        if (r10 == null) goto L9;
        ImageEntity r11 = new ImageEntity(r10.a, r10.b, r10.c, r10.d, null, 16, null);
    L10:
        kc8.g0 r12 = r26.e;
        if (r12 == null) goto L13;
        ImageEntity r13 = new ImageEntity(r12.a, r12.b, r12.c, r12.d, null, 16, null);
    L14:
        kc8.g0 r0 = r26.f;
        if (r0 == null) goto L17;
        ImageEntity r1 = new ImageEntity(r0.a, r0.b, r0.c, r0.d, null, 16, null);
    L18:
        IAIChatUgcAIGCService.a.a(r2, r24, r25, r5, new df8.a(r27, new ImageItem(r7, r8, r9, r11, r13, r1, null, null, null, null, null, false, null, null, 16320, null), null, null), r28, r29);
        return;
    L17:
        r1 = null;
        goto L18
    L13:
        r13 = null;
        goto L14
    L9:
        r11 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }
}
