package da2;

import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.h;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import com.bytedance.android.livesdk.interactivity.textmessage.model.AudioChatTextMessage;
import com.bytedance.android.livesdk.interactivity.textmessage.render.TextMessageRichContentHelper;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import ek6.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements k<f<?>> {
    public final TextMessageRichContentHelper a;
    public final e52.a b;

    public static final class a extends nk6.a {
        public final /* synthetic */ l a;

        public a(l r1) {
            this.a = r1;
        }

        public final void b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a.a(r2);
        }

        public final boolean a(View r3, ek6.c r4, ClickableSpan r5) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "action");
            Intrinsics.checkNotNullParameter(r5, "span");
            tb2.b r1 = null;
            if ((r4 instanceof ib2.a) == true) goto L5;
            r4 = null;
        L5:
            ib2.a r6 = (ib2.a) r4;
            if (r6 == null) goto L8;
            r1 = r6.a;
        L8:
            if (r1 != null) goto L12;
            return false;
        L12:
            return this.a.b(r3, r1, r5);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final String getName() {
        return "TextMessageRenderTextProcessorV2";
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final void a(f<?> r2) {
        f<?> r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "message");
        r3.F = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final View.OnClickListener c(l r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        return new a(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final void d(f<?> r4) {
        f<?> r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "message");
        if (r5.F != null) goto L6;
        r5.F = f(r5, new com.bytedance.android.livesdk.interactivity.service.richcontent.config.b(true, (int) (h.b * com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.b(this.b)), true));
        return;
    }

    public final com.bytedance.android.livesdk.interactivity.service.richcontent.config.b e(com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f r4) {
        return new com.bytedance.android.livesdk.interactivity.service.richcontent.config.b(true, (int) (h.b * com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.b(this.b)), r4.a);
    }

    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d f(f r38, com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r39) {
        if ((r38 instanceof AudioChatTextMessage) == false) goto L78;
        TextMessageRichContentHelper r2 = this.a;
        AudioChatTextMessage r1 = (AudioChatTextMessage) r38;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "textMessage");
        Pair<tb2.d, i> r4 = r2.a(r1);
        tb2.d r5 = (tb2.d) r4.component1();
        i r6 = (i) r4.component2();
        bk6.a r7 = new bk6.a();
        float r8 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.b(r2.f);
        e r9 = mb2.c.c(r5, r8, "public_screen");
        List r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "contents");
        ((ArrayList) r7.a).addAll(r10);
        r7.b = r9.b;
        Iterator r11 = r9.a.iterator();
        String r13 = BuildConfig.FLAVOR;
    L5:
        jb2.d r14 = null;
        if (r11.hasNext() == false) goto L14;
        jb2.d r15 = (ek6.d) r11.next();
        if ((r15 instanceof jb2.d) == false) goto L11;
        r14 = r15;
    L11:
        jb2.d r16 = r14;
        if (r16 == null) goto L5;
        r13 = r13 + r16.d;
        goto L5
    L14:
        long r17 = r1.b.getAudioDuration();
        long r18 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        if (r17 >= r18) goto L17;
        long r19 = 1;
    L19:
        if (r1.b.getReadStatus() != 0) goto L21;
        boolean r20 = true;
    L22:
        int r21 = (int) (s1.f(14.0f) * r8);
        String r35 = r13;
        long r110 = 5;
        if (1 <= r19) goto L26;
    L28:
        long r111 = 10;
        if (6 <= r19) goto L32;
    L34:
        int r23 = (int) (s1.f(65.0f) * r8);
        String r24 = "audio_comment/comment_long.json";
    L35:
        int r28 = r23;
    L36:
        ob2.e r25 = new ob2.e(r24);
        ImageStyle.AdjustType r112 = ImageStyle.AdjustType.EXACTLY;
        if (r20 == false) goto L39;
        int r33 = 255;
    L40:
        r7.a(new jb2.c(r25, new ImageStyle(r112, r21, r28, 0.0f, 0, 0, ImageStyle.PlaceHolderType.FIX_SIZE, null, null, r28, r21, null, 0, s1.f(5.0f), r33, 1030584), new ib2.a(new com.bytedance.android.livesdk.interactivity.textmessage.render.a()), null));
        StringBuilder r26 = new StringBuilder();
        r26.append(r19);
        r26.append('\"');
        String r27 = r26.toString();
        if (r20 == false) goto L43;
        int r29 = -1;
    L44:
        r7.a(new jb2.d(r27, new gk6.a(Integer.valueOf(r29)), new ib2.a(new com.bytedance.android.livesdk.interactivity.textmessage.render.a()), 8));
        String r30 = r1.b.getContent();
        a5 r31 = r1.b.getRtfContent();
        if (r31 == null) goto L47;
        r7.a(new jb2.d("\n", null, null, 14));
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        x r34 = r.b;
        yb2.a r3 = r2.b(r1);
        Intrinsics.checkNotNullParameter(r31, "text");
        tb2.d r36 = r.a(r31, r3);
        int r37 = mb2.c.a;
        List r40 = mb2.c.c(r36, com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.b(r2.f), "public_screen").a;
        Intrinsics.checkNotNullParameter(r40, "contents");
        ((ArrayList) r7.a).addAll(r40);
    L51:
        String r41 = r35 + s1.C(2131914437, new Object[]{String.valueOf(r19)});
        if (r30 == null) goto L54;
        r41 = r41 + tb2.c.DEFAULT_TEXT + r30 + tb2.c.DEFAULT_TEXT;
    L54:
        Iterator r43 = r9.a.iterator();
    L56:
        if (r43.hasNext() == false) goto L77;
        ek6.d r44 = (ek6.d) r43.next();
        if ((r44 instanceof jb2.a) == true) goto L60;
        r44 = null;
    L60:
        jb2.a r45 = (jb2.a) r44;
        if (r45 == null) goto L56;
        jb2.b r46 = r45.b();
        if (r46 == null) goto L56;
        if (TextUtils.isEmpty(r46.a) == true) goto L70;
        if (r46.b != 1) goto L70;
        boolean r47 = true;
    L71:
        if (r47 == true) goto L74;
        r46 = null;
    L74:
        if (r46 == null) goto L56;
        r41 = r41 + r46.a;
    L70:
        r47 = false;
        goto L71
    L77:
        r6.d = r41;
        Pair r48 = new Pair(new e(CollectionsKt.toMutableList(r7.a), r7.b), r6);
        Pair r49 = new Pair((e) r48.component1(), (i) r48.component2());
    L80:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d(LiveRichContentEngine.a().a().e((e) r49.component1(), r39), (i) r49.component2());
    L47:
        if (r30 == null) goto L51;
        if (TextUtils.isEmpty(r30) == true) goto L51;
        r7.a(new jb2.d("\n", null, null, 14));
        r7.a(new jb2.d(r30, new gk6.a(-1), null, 12));
        goto L51
    L43:
        r29 = ColorProtector.parseColor("#b2ffffff");
        goto L44
    L39:
        r33 = (int) 178.5d;
        goto L40
    L32:
        if (r111 < r19) goto L34;
        r23 = (int) (s1.f(45.0f) * r8);
        r24 = "audio_comment/comment_mid.json";
        goto L35
    L26:
        if (r110 < r19) goto L28;
        r24 = "audio_comment/comment_short.json";
        r28 = (int) (s1.f(32.0f) * r8);
        goto L36
    L21:
        r20 = false;
        goto L22
    L17:
        r19 = r1.b.getAudioDuration() / r18;
        goto L19
    L78:
        TextMessageRichContentHelper r50 = this.a;
        r50.getClass();
        Intrinsics.checkNotNullParameter(r38, "textMessage");
        Pair<tb2.d, i> r51 = r50.a(r38);
        tb2.d r53 = (tb2.d) r51.component1();
        i r54 = (i) r51.component2();
        int r55 = mb2.c.a;
        Pair r56 = new Pair(mb2.c.c(r53, com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.b(r50.f), "public_screen"), r54);
        r49 = new Pair((e) r56.component1(), (i) r56.component2());
        goto L80
    }

    public c(boolean r2, boolean r3, e52.a r4) {
        this.b = r4;
        this.a = new TextMessageRichContentHelper(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final j b(f<?> r5, com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f r6, k.a<f<?>> r7) {
        f<?> r8 = r5;
        Intrinsics.checkNotNullParameter(r8, "message");
        Intrinsics.checkNotNullParameter(r6, "config");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d r1 = r8.F;
        if ((r1 instanceof com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d) == true) goto L5;
        r1 = null;
    L5:
        r0.element = r1;
        if (r1 != null) goto L9;
        r0.element = f(r8, e(r6));
    L9:
        if (((com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d) r0.element).a.b == true) goto L11;
        LiveRichContentEngine.a().a().d(((com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d) r0.element).a, e(r6), new d(r7, r8, r0));
    L11:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d r9 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d) r0.element;
        return new j(r9.a.a, r9.b);
    }
}
