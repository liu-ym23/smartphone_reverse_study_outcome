package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import android.util.Size;
import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService;
import com.larus.bmhome.chat.block.base.config.RichMediaCreationImageButtonAction;
import com.larus.bmhome.chat.block.base.config.RichMediaCreationVideoButtonAction;
import com.larus.bmhome.chat.component.creation.CreationExposureMediaType;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaItemAction;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaKind;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaOverlayAlignment;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.im.bean.message.block.GenericImageItem;
import com.larus.im.bean.message.block.GenericVideoItem;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.RichMediaType;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kc8.p0;
import kc8.s0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import tx9.a4;
import tx9.u2;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h0 {
    public static final fn8.b0 q = null;
    public e0 a;
    public f0 b;
    public List<fn8.c> c;
    public List<Size> d;
    public List<fn8.x> e;
    public u f;
    public d0 g;
    public b0 h;
    public Job i;
    public long j;
    public Function0<Unit> k;
    public final Set<String> l;
    public final Set<String> m;
    public final Map<String, Job> n;
    public final Map<String, Long> o;
    public final b p;

    public static final class a {
    }

    public static final class b implements fn8.c0 {
        public final /* synthetic */ h0 a;

        @Override // fn8.c0
        public final boolean b() {
            f0 r0 = this.a.b;
            if (r0 == null) goto L7;
            r0.o();
            return true;
        L7:
            return true;
        }

        @Override // fn8.c0
        public final void e() {
            h0 r0 = this.a;
            List<fn8.x> r1 = r0.e;
            if ((r1 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r2 = r1.iterator();
        L9:
            if (r2.hasNext() == false) goto L13;
            if (((fn8.x) r2.next()).l == false) goto L9;
            boolean r3 = false;
        L14:
            if (r3 == true) goto L30;
            f0 r4 = r0.b;
            if (r4 == null) goto L31;
            CoroutineScope r5 = r4.c();
            if (r5 == null) goto L32;
            Job r6 = r0.i;
            if (r6 == null) goto L25;
            Job.DefaultImpls.cancel$default(r6, null, 1, null);
        L25:
            r0.i = BuildersKt.launch$default(r5, null, null, new RichMediaLayoutViewModel$requestCreationVideoAutoPlayCheck$2(r4, null), 3, null);
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L13:
            r3 = true;
            goto L14
        L5:
            if (r1.isEmpty() == false) goto L7;
            goto L7
        }

        public b(h0 r1) {
            this.a = r1;
        }

        @Override // fn8.c0
        public final void h(String r3) {
            Intrinsics.checkNotNullParameter(r3, "stableKey");
            b0 r1 = this.a.h;
            if (r1 == null) goto L8;
            Intrinsics.checkNotNullParameter(r3, "stableKey");
            kc8.d0 r4 = r1.g.remove(r3);
            if (r4 == null) goto L9;
            r4.recycle();
            return;
        L9:
            return;
        }

        @Override // fn8.c0
        public final void a(String r22, float r23) {
            Intrinsics.checkNotNullParameter(r22, "stableKey");
            int r1 = h0.b(this.a, r22);
            fn8.c r2 = (fn8.c) CollectionsKt.getOrNull(this.a.c, r1);
            if (r2 != null) goto L5;
            return;
        L5:
            d0 r3 = this.a.g;
            if (r3 == null) goto L47;
            Intrinsics.checkNotNullParameter(r2, "item");
            fn8.b r4 = r2.h;
            if ((r4 instanceof fn8.b.a) == false) goto L10;
            fn8.b.a r5 = (fn8.b.a) r4;
        L11:
            if (r5 == null) goto L48;
            CreationItem r6 = r5.a;
            if (r6 == null) goto L49;
            Integer r7 = r6.type;
            if (r7 == null) goto L50;
            boolean r8 = true;
            if (r7.intValue() != 1) goto L51;
            d0.b r9 = r3.c(r6, r1);
            if (r9 == null) goto L52;
            String r10 = r9.h;
            f0 r11 = r3.b;
            if (r11 == null) goto L33;
            Fragment r12 = r11.getHostFragment();
            if (r12 == null) goto L33;
            t1a.b r13 = s1a.a.g(r12);
            if (r13 == null) goto L33;
            qd8.c r14 = r13.getAbility(qd8.c.class);
            if (r14 == null) goto L33;
            boolean r15 = r14.cq(CreationExposureMediaType.IMAGE, r3.a.a.getMessageId(), r10, r23);
        L34:
            if (r15 == false) goto L53;
            i0 r16 = r3.f(r2, r1);
            IAIChatControlTraceService.Companion r17 = IAIChatControlTraceService.a;
            String r18 = r3.a.a.getReplyId();
            if (r18 != null) goto L39;
            r18 = "";
        L39:
            String r19 = r17.Sa(r18);
            if (r19.length() == 0) goto L43;
            r8 = false;
        L43:
            if (r8 == false) goto L45;
            r19 = "other";
        L45:
            u2.d(r19, Integer.valueOf(r9.a), null, r3.a(), r3.a.a.getMessageId(), r9.g, r9.e, Boolean.valueOf(r9.i), Boolean.valueOf(r9.j), Boolean.valueOf(com.larus.im.bean.message.a.C0(r3.a.a)), tz9.a.a(r3.a.a), Boolean.TRUE, Float.valueOf(r23), r9.h, r16.b(), 32768);
            return;
        L53:
            return;
        L33:
            r15 = true;
            goto L34
        L52:
            return;
        L51:
            return;
        L50:
            return;
        L49:
            return;
        L48:
            return;
        L10:
            r5 = null;
            goto L11
        }

        @Override // fn8.c0
        public final void c(String r23, Size r24) {
            Intrinsics.checkNotNullParameter(r23, "stableKey");
            Intrinsics.checkNotNullParameter(r24, "itemSize");
            int r1 = h0.b(this.a, r23);
            fn8.c r4 = (fn8.c) CollectionsKt.getOrNull(this.a.c, r1);
            if (r4 != null) goto L5;
            return;
        L5:
            d0 r5 = this.a.g;
            if (r5 == null) goto L91;
            Intrinsics.checkNotNullParameter(r4, "item");
            Intrinsics.checkNotNullParameter(r24, "itemSize");
            fn8.b r3 = r4.h;
            if ((r3 instanceof fn8.b.d) == false) goto L10;
        L57:
            d0.d r6 = r5.e(r4);
            if (r6 == null) goto L100;
            i0 r7 = r5.f(r4, r1);
            int r2 = r1 + 1;
            d0.g(new d0.c(r5.a.a.getMessageId(), r6.a, r5.a.c, r2, r6.b, r5.a.a.getReplyId(), r6.d, r6.g, r5.b(), null, r7, 512));
            com.larus.platform.service.o r8 = com.larus.platform.service.o.a;
            JSONObject r9 = new JSONObject();
            f0 r10 = r5.b;
            String r11 = null;
            if (r10 == null) goto L63;
            String r12 = r10.getCurrentPage();
        L64:
            r9.putOpt("current_page", r12);
            f0 r13 = r5.b;
            if (r13 == null) goto L67;
            r11 = r13.b();
        L67:
            r9.putOpt("previous_page", r11);
            r9.putOpt(MusicAppletPage.KEY_MESSAGE_ID, r5.a.a.getMessageId());
            f0 r14 = r5.b;
            if (r14 == null) goto L71;
            String r15 = r14.getConversationId();
            if (r15 == null) goto L71;
        L72:
            r9.putOpt(MusicAppletPage.KEY_CONVERSATION_ID, r15);
            r9.putOpt("bot_id", r5.a());
            f0 r16 = r5.b;
            if (r16 == null) goto L76;
            String r17 = r16.getChatType();
            if (r17 == null) goto L76;
        L77:
            r9.putOpt("chat_type", r17);
            r9.putOpt("reply_id", r5.a.a.getReplyId());
            r9.putOpt("module_position", "within_text");
            if (r5.c.size() != 1) goto L80;
            String r18 = "single_card";
        L81:
            r9.putOpt("module_type", r18);
            r9.putOpt("card_id", r6.a);
            r9.putOpt("card_type", r6.b);
            r9.putOpt("card_position", Integer.valueOf(r5.a.c));
            r9.putOpt("card_sub_position", Integer.valueOf(r2));
            ri8.c r19 = ri8.c.a;
            r9.putOpt("card_size", ri8.c.h(r24.getWidth(), r24.getHeight()));
            r9.putOpt("video_id", r6.e);
            r9.putOpt("module_order", Integer.valueOf(r5.a.c));
            r9.putOpt("req_id", j0.a(r5.a.a));
            r9.putOpt("slidemode", r6.f);
            r9.putOpt("module_source", r6.d);
            r9.putOpt("image_resolution", ri8.c.a(r6.g));
            r9.putOpt("content_type", "normal");
            LruCache<String, wc9.e> r20 = ko8.a.a;
            r9.putOpt("agent_id", ko8.a.c(r5.a.a));
            r9.putOpt("agent_tool", ko8.a.d(r5.a.a));
            r9.putOpt("tool_name", r6.h);
            r9.putOpt("doc_id", r6.i);
            r9.putOpt("search_id", r6.k);
            String r21 = r6.j;
            if (r21 == null) goto L84;
            r9.putOpt("host_enter_from", r21);
        L84:
            Iterator r22 = MapsKt.plus(MapsKt.plus(r6.l, r7.c()), TuplesKt.to("rich_media_type", r5.b())).entrySet().iterator();
        L86:
            if (r22.hasNext() == false) goto L88;
            Map.Entry r25 = (Map.Entry) r22.next();
            r9.putOpt((String) r25.getKey(), r25.getValue());
            goto L86
        L88:
            Unit r26 = Unit.INSTANCE;
            r8.reportEvent("show_card", r9);
            return;
        L80:
            r18 = "multiple_card";
        L76:
            r17 = "default";
        L71:
            r15 = r5.a.a.getConversationId();
            goto L72
        L63:
            r12 = null;
            goto L64
        L100:
            return;
        L10:
            if ((r3 instanceof fn8.b.e) == true) goto L57;
            boolean r27 = false;
            if ((r3 instanceof fn8.b.a) == false) goto L38;
            CreationItem r28 = ((fn8.b.a) r3).a;
            d0.b r29 = r5.c(r28, r1);
            if (r29 == null) goto L97;
            i0 r30 = r5.f(r4, r1);
            Integer r31 = r28.type;
            if (r31 != null) goto L21;
        L23:
            if (r31 != null) goto L26;
            return;
        L26:
            if (r31.intValue() != 2) goto L93;
            VideoData r32 = r28.video;
            if (r32 == null) goto L35;
            Integer r33 = r32.status;
            if (r33 == null) goto L35;
            if (r33.intValue() != 3) goto L35;
            r27 = true;
        L35:
            if (r27 == false) goto L99;
            d0.g(d0.d(r29, r5.a.a.getMessageId(), r5.a.a.getReplyId(), r5.a.c, 1 + r1, r30));
            a4.d(r29.f, r5.a.a.getMessageId(), r5.a(), tz9.a.a(r5.a.a), Integer.valueOf(r29.a), r29.h, Float.valueOf(0.5f), r30.b(), 256);
            return;
        L99:
            return;
        L93:
            return;
        L21:
            if (r31.intValue() != 1) goto L23;
            d0.g(d0.d(r29, r5.a.a.getMessageId(), r5.a.a.getReplyId(), r5.a.c, r1 + 1, r30));
            return;
        L97:
            return;
        L38:
            boolean r34 = r3 instanceof fn8.b.C0108b;
            if (r34 == false) goto L41;
        L45:
            if (r34 == false) goto L51;
            String r35 = r5.a.a.getMessageId();
            fn8.b.C0108b r36 = (fn8.b.C0108b) r3;
            String r37 = r36.a.id;
            if (r37 != null) goto L49;
            r37 = r4.a;
        L49:
            String r110 = r37;
            e0 r38 = r5.a;
            String r111 = r38.a.getReplyId();
            GenericImageItem r39 = r36.a;
            d0.c r112 = new d0.c(r35, r110, r38.c, r1 + 1, "picture", r111, "slideshow", CollectionsKt.listOf(new Integer[]{r39.width, r39.height}), null, null, r5.f(r4, r1), 768);
        L56:
            d0.g(r112);
            return;
        L51:
            if ((r3 instanceof fn8.b.c) == false) goto L95;
            String r113 = r5.a.a.getMessageId();
            fn8.b.c r40 = (fn8.b.c) r3;
            String r41 = r40.a.id;
            if (r41 != null) goto L55;
            r41 = r4.a;
        L55:
            String r114 = r41;
            e0 r42 = r5.a;
            String r115 = r42.a.getReplyId();
            GenericVideoItem r43 = r40.a;
            r112 = new d0.c(r113, r114, r42.c, r1 + 1, "video", r115, "slideshow", CollectionsKt.listOf(new Integer[]{r43.width, r43.height}), null, null, r5.f(r4, r1), 768);
            goto L56
        L95:
            return;
        L41:
            if ((r3 instanceof fn8.b.c) == true) goto L45;
            throw new NoWhenBranchMatchedException();
        }

        @Override // fn8.c0
        public final void d(String r58, fn8.w r59) {
            Intrinsics.checkNotNullParameter(r58, "stableKey");
            Intrinsics.checkNotNullParameter(r59, "anchor");
            int r5 = h0.b(this.a, r58);
            fn8.c r6 = (fn8.c) CollectionsKt.getOrNull(this.a.c, r5);
            if (r6 != null) goto L5;
            return;
        L5:
            h0 r7 = this.a;
            final d0 r8 = r7.g;
            if (r8 == null) goto L84;
            Size r9 = (Size) CollectionsKt.getOrNull(r7.d, r5);
            Intrinsics.checkNotNullParameter(r6, "item");
            fn8.b r11 = r6.h;
            if ((r11 instanceof fn8.b.d) == false) goto L10;
        L49:
            final d0.d r12 = r8.e(r6);
            if (r12 == null) goto L84;
            final i0 r13 = r8.f(r6, r5);
            ri8.c r14 = ri8.c.a;
            String r15 = r12.a;
            String r16 = r8.a.a.getMessageId();
            f0 r17 = r8.b;
            if (r17 == null) goto L56;
            String r18 = r17.getConversationId();
            if (r18 == null) goto L56;
        L57:
            String r19 = r18;
            String r110 = r8.a.a.getReplyId();
            f0 r111 = r8.b;
            if (r111 == null) goto L60;
            String r112 = r111.getCurrentPage();
        L61:
            f0 r113 = r8.b;
            if (r113 == null) goto L64;
            String r20 = r113.b();
        L65:
            Integer r21 = Integer.valueOf(r8.a.c);
            Integer r22 = Integer.valueOf(r5 + 1);
            String r10 = r12.d;
            String r114 = r12.b;
            f0 r23 = r8.b;
            if (r23 == null) goto L69;
            String r24 = r23.getBotId();
            if (r24 == null) goto L69;
        L70:
            String r26 = r24;
            if (r9 == null) goto L73;
            String r27 = ri8.c.h(r9.getWidth(), r9.getHeight());
        L75:
            if (r8.c.size() != 1) goto L77;
            String r25 = "single_card";
        L78:
            String r28 = r25;
            String r29 = r12.c;
            Integer r31 = Integer.valueOf(r8.a.c);
            String r30 = r12.e;
            String r33 = j0.a(r8.a.a);
            String r115 = r12.f;
            List<Integer> r2 = r12.g;
            LruCache<String, wc9.e> r210 = ko8.a.a;
            String r41 = ko8.a.c(r8.a.a);
            String r42 = ko8.a.d(r8.a.a);
            String r4 = r12.h;
            f0 r32 = r8.b;
            if (r32 == null) goto L81;
            String r44 = r32.getChatType();
        L82:
            ri8.c.m(r15, r16, r19, r110, r112, r20, r21, r22, r10, "within_text", r114, r26, r27, r28, "open_media", r29, r31, r30, r33, r115, null, r2, "normal", null, null, null, r41, r42, r4, r44, null, r12.i, null, null, r12.j, new c0(r12, r13, r8), r12.k, null, 1133510656, 35);
            goto L84
        L81:
            r44 = null;
            goto L82
        L77:
            r25 = "multiple_card";
            goto L78
        L73:
            r27 = null;
        L69:
            r24 = r8.a.a.getSenderId();
            goto L70
        L64:
            r20 = null;
            goto L65
        L60:
            r112 = null;
        L56:
            r18 = r8.a.a.getConversationId();
            goto L57
        L10:
            if ((r11 instanceof fn8.b.e) == true) goto L49;
            if ((r11 instanceof fn8.b.a) == false) goto L43;
            CreationItem r34 = ((fn8.b.a) r11).a;
            Integer r116 = r34.type;
            if (r116 == null) goto L84;
            if (r116.intValue() != 1) goto L84;
            d0.b r35 = r8.c(r34, r5);
            if (r35 == null) goto L84;
            i0 r36 = r8.f(r6, r5);
            com.larus.platform.service.o r117 = com.larus.platform.service.o.a;
            JSONObject r118 = new JSONObject();
            String r119 = r8.a();
            String r120 = "";
            if (r119 != null) goto L26;
            r119 = "";
        L26:
            r118.put("bot_id", r119);
            r118.put(MusicAppletPage.KEY_MESSAGE_ID, r8.a.a.getMessageId());
            f0 r121 = r8.b;
            if (r121 == null) goto L30;
            String r122 = r121.getConversationId();
            if (r122 == null) goto L30;
        L31:
            if (r122 != null) goto L33;
            r122 = "";
        L33:
            r118.put(MusicAppletPage.KEY_CONVERSATION_ID, r122);
            r118.put("user_type", "bot");
            r118.put("pic_position", String.valueOf(r35.a));
            r118.put("pic_id", r35.e);
            String r123 = r35.g;
            if (r123 == null) goto L37;
            r120 = r123;
        L37:
            r118.put("request_id", r120);
            r118.put("is_onboarding", 0);
            r118.putOpt("creation_task_id", r35.h);
            if (com.larus.im.bean.message.a.C0(r8.a.a) == false) goto L40;
            String r124 = "1";
        L41:
            r118.putOpt("is_deep_thinking", r124);
            r118.putOpt("ai_create_show_mode", tz9.a.a(r8.a.a));
            r118.putOpt("is_image_edit", Integer.valueOf(r35.j ? 1 : 0));
            r118.putOpt("is_replica_gen", Integer.valueOf(r35.i ? 1 : 0));
            r36.a(r118);
            Unit r37 = Unit.INSTANCE;
            r117.reportEvent("picture_message_click", r118);
            goto L84
        L40:
            r124 = TriggerSendLoading.NO_LOADING;
        L30:
            r122 = r8.a.a.getConversationId();
            goto L31
        L43:
            if ((r11 instanceof fn8.b.C0108b) == true) goto L84;
            if ((r11 instanceof fn8.b.c) == true) goto L84;
            throw new NoWhenBranchMatchedException();
        L84:
            h0 r3 = this.a;
            u r38 = r3.f;
            if (r38 == null) goto L96;
            b0 r39 = r3.h;
            if (r39 == null) goto L91;
            Intrinsics.checkNotNullParameter(r58, "stableKey");
            kc8.d0 r1 = (kc8.d0) ((LinkedHashMap) r39.g).get(r58);
            if (r1 == null) goto L91;
            s0 r40 = r1.a();
        L92:
            Intrinsics.checkNotNullParameter(r6, "item");
            Intrinsics.checkNotNullParameter(r59, "anchor");
            w r43 = r38.h;
            r43.getClass();
            Intrinsics.checkNotNullParameter(r6, "item");
            Intrinsics.checkNotNullParameter(r59, "anchor");
            v r45 = r43.a.get(Integer.valueOf(r6.b));
            if (r45 == null) goto L97;
            r45.a(r6, r59, r40);
            return;
        L97:
            return;
        L91:
            r40 = null;
            goto L92
        }

        @Override // fn8.c0
        public final void f(String r17, fn8.w r18, Size r19) {
            Intrinsics.checkNotNullParameter(r17, "stableKey");
            Intrinsics.checkNotNullParameter(r18, "anchor");
            Intrinsics.checkNotNullParameter(r19, "itemSize");
            fn8.c r8 = h0.a(this.a, r17);
            if (r8 != null) goto L5;
            return;
        L5:
            final u r5 = this.a.f;
            if (r5 == null) goto L34;
            Intrinsics.checkNotNullParameter(r8, "item");
            Intrinsics.checkNotNullParameter(r18, "anchor");
            Intrinsics.checkNotNullParameter(r19, "itemSize");
            r18.setOnLongClickListener(new h(r5));
            fn8.b r1 = r8.h;
            if ((r1 instanceof fn8.b.d) == false) goto L10;
            return;
        L10:
            if ((r1 instanceof fn8.b.e) == false) goto L19;
            f0 r2 = r5.e;
            if (r2 == null) goto L14;
            q0.a r3 = r2.r();
        L15:
            if (r3 == null) goto L39;
            IAIChatUgcAIGCService.a.M0(r18, r5.a, r3);
            return;
        L39:
            return;
        L14:
            r3 = null;
            goto L15
        L19:
            if ((r1 instanceof fn8.b.a) == false) goto L28;
            CreationItem r4 = ((fn8.b.a) r1).a;
            int r7 = r5.f(r4);
            f0 r9 = r5.e;
            if (r9 == null) goto L40;
            CoroutineScope r10 = r9.c();
            if (r10 == null) goto L41;
            BuildersKt.launch$default(r10, null, null, new RichMediaItemActionDispatcher$bindCreationLongClick$1(r18, r5, r4, r7, r19, r9, r8, null), 3, null);
            return;
        L41:
            return;
        L40:
            return;
        L28:
            if ((r1 instanceof fn8.b.C0108b) == false) goto L30;
            return;
        L30:
            if ((r1 instanceof fn8.b.c) == false) goto L33;
            return;
        L33:
            throw new NoWhenBranchMatchedException();
        }

        @Override // fn8.c0
        public final void g(String r18, RichMediaItemAction r19, View r20, Function0<Unit> r21) {
            Intrinsics.checkNotNullParameter(r18, "stableKey");
            Intrinsics.checkNotNullParameter(r19, "action");
            Intrinsics.checkNotNullParameter(r20, "anchor");
            Intrinsics.checkNotNullParameter(r21, "onCompleted");
            fn8.c r10 = h0.a(this.a, r18);
            if (r10 != null) goto L6;
            r21.invoke();
            return;
        L6:
            u r7 = this.a.f;
            if (r7 == null) goto L74;
            Intrinsics.checkNotNullParameter(r10, "item");
            Intrinsics.checkNotNullParameter(r19, "action");
            Intrinsics.checkNotNullParameter(r20, "anchor");
            Intrinsics.checkNotNullParameter(r21, "onCompleted");
            if (r19 != RichMediaItemAction.DOWNLOAD) goto L14;
            y r2 = r7.g;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r10, "item");
            Intrinsics.checkNotNullParameter(r20, "anchor");
            Intrinsics.checkNotNullParameter(r21, "onCompleted");
            z r1 = r2.a.get(Integer.valueOf(r10.b));
            if (r1 == null) goto L13;
            r1.a(r10, r20, r21);
            return;
        L13:
            r21.invoke();
            return;
        L14:
            int r3 = u.b.a[r10.c.ordinal()];
            fn8.b.a r5 = null;
            if (r3 == 1) goto L47;
            if (r3 != 2) goto L45;
            switch(u.b.b[r19.ordinal()]) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L24;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L22;
                default: goto L21;
            };
        L22:
            RichMediaCreationVideoButtonAction r4 = RichMediaCreationVideoButtonAction.EXTEND;
        L26:
            RichMediaCreationVideoButtonAction r6 = r4;
        L27:
            if (r6 == null) goto L43;
            fn8.b r8 = r10.h;
            if ((r8 instanceof fn8.b.a) == false) goto L31;
            r5 = (fn8.b.a) r8;
        L31:
            if (r5 == null) goto L42;
            CreationItem r9 = r5.a;
            if (r9 == null) goto L42;
            f0 r11 = r7.e;
            if (r11 != null) goto L38;
            r21.invoke();
            return;
        L38:
            CoroutineScope r12 = r11.c();
            if (r12 != null) goto L41;
            r21.invoke();
            return;
        L41:
            BuildersKt.launch$default(r12, null, null, new RichMediaItemActionDispatcher$onCreationVideoButtonClick$1(r6, r20, r7, r9, r11, r12, r21, r10, null), 3, null);
            return;
        L42:
            r21.invoke();
            return;
        L43:
            r21.invoke();
            return;
        L23:
            r4 = RichMediaCreationVideoButtonAction.CITE;
            goto L26
        L24:
            r6 = null;
            goto L27
        L25:
            r4 = RichMediaCreationVideoButtonAction.DOWNLOAD;
            goto L26
        L21:
            throw new NoWhenBranchMatchedException();
        L45:
            throw new NoWhenBranchMatchedException();
        L47:
            switch(u.b.b[r19.ordinal()]) {
                case 1: goto L55;
                case 2: goto L54;
                case 3: goto L53;
                case 4: goto L52;
                case 5: goto L51;
                case 6: goto L50;
                default: goto L49;
            };
        L50:
            RichMediaCreationImageButtonAction r13 = null;
        L57:
            if (r13 == null) goto L73;
            fn8.b r14 = r10.h;
            if ((r14 instanceof fn8.b.a) == false) goto L61;
            r5 = (fn8.b.a) r14;
        L61:
            if (r5 == null) goto L72;
            CreationItem r15 = r5.a;
            if (r15 == null) goto L72;
            f0 r16 = r7.e;
            if (r16 != null) goto L68;
            r21.invoke();
            return;
        L68:
            CoroutineScope r17 = r16.c();
            if (r17 != null) goto L71;
            r21.invoke();
            return;
        L71:
            BuildersKt.launch$default(r17, null, null, new RichMediaItemActionDispatcher$onCreationImageButtonClick$1(r13, r20, r7, r15, r16, r17, r10, r21, null), 3, null);
            return;
        L72:
            r21.invoke();
            return;
        L73:
            r21.invoke();
            return;
        L51:
            RichMediaCreationImageButtonAction r22 = RichMediaCreationImageButtonAction.CITE;
        L56:
            r13 = r22;
            goto L57
        L52:
            r22 = RichMediaCreationImageButtonAction.VIDEO_EDIT;
            goto L56
        L53:
            r22 = RichMediaCreationImageButtonAction.IMAGE_EDIT;
            goto L56
        L54:
            r22 = RichMediaCreationImageButtonAction.SHARE;
            goto L56
        L55:
            r22 = RichMediaCreationImageButtonAction.DOWNLOAD;
            goto L56
        L49:
            throw new NoWhenBranchMatchedException();
        L74:
            r21.invoke();
        }

        @Override // fn8.c0
        public final void i(String r16, VideoPlayView r17, fn8.r r18, fn8.s r19) {
            Intrinsics.checkNotNullParameter(r16, "stableKey");
            Intrinsics.checkNotNullParameter(r17, "playbackView");
            Intrinsics.checkNotNullParameter(r18, "onReady");
            Intrinsics.checkNotNullParameter(r19, "onPlayingChanged");
            b0 r6 = this.a.h;
            if (r6 == null) goto L42;
            Intrinsics.checkNotNullParameter(r16, "stableKey");
            Intrinsics.checkNotNullParameter(r17, "playbackView");
            Intrinsics.checkNotNullParameter(r18, "onReady");
            Intrinsics.checkNotNullParameter(r19, "onPlayingChanged");
            Intrinsics.checkNotNullParameter(r16, "stableKey");
            kc8.d0 r2 = r6.g.remove(r16);
            if (r2 == null) goto L7;
            r2.recycle();
        L7:
            fn8.c r3 = (fn8.c) ((LinkedHashMap) r6.d).get(r16);
            if (r3 != null) goto L10;
            r18.invoke(Boolean.FALSE);
            return;
        L10:
            fn8.b r4 = r3.h;
            if ((r4 instanceof fn8.b.a) == false) goto L13;
            fn8.b.a r5 = (fn8.b.a) r4;
        L14:
            if (r5 == null) goto L16;
            CreationItem r7 = r5.a;
        L17:
            f0 r8 = r6.c;
            if (r8 == null) goto L20;
            kc8.q r9 = r8.g();
        L21:
            f0 r10 = r6.c;
            if (r10 == null) goto L24;
            CoroutineScope r11 = r10.c();
        L26:
            if (r3.b == RichMediaType.CREATION.getValue()) goto L28;
        L41:
            r18.invoke(Boolean.FALSE);
            return;
        L28:
            if (r3.c != RichMediaKind.VIDEO) goto L41;
            if (r7 == null) goto L41;
            if (r11 == null) goto L41;
            kc8.d0 r12 = IRichMediaCreationClickService.a.g();
            r6.g.put(r16, r12);
            Message r13 = r6.a;
            Integer r14 = r6.f.get(r16);
            if (r14 == null) goto L35;
            int r15 = r14.intValue();
        L36:
            Message r110 = r6.a;
            String r111 = r6.b;
            Integer r0 = r6.e.get(r16);
            if (r0 == null) goto L39;
            int r1 = r0.intValue();
        L40:
            r12.b(r17, r13, r7, r15, r9, r11, j0.b(r3, r110, r111, r1).b(), r18, r19);
            return;
        L39:
            r1 = 1;
            goto L40
        L35:
            r15 = 0;
            goto L36
        L24:
            r11 = null;
            goto L26
        L20:
            r9 = null;
            goto L21
        L16:
            r7 = null;
            goto L17
        L13:
            r5 = null;
            goto L14
        L42:
            r18.invoke(Boolean.FALSE);
        }
    }

    static {
        q = new fn8.b0(CollectionsKt.emptyList(), 0, 0);
    }

    public final void f() {
        Iterator r0 = ((LinkedHashMap) this.n).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Job.DefaultImpls.cancel$default((Job) r0.next(), null, 1, null);
        goto L4
    L6:
        ((LinkedHashMap) this.n).clear();
        this.l.clear();
        this.m.clear();
    }

    public h0() {
        this.c = CollectionsKt.emptyList();
        this.d = CollectionsKt.emptyList();
        this.e = CollectionsKt.emptyList();
        this.l = new LinkedHashSet();
        this.m = new LinkedHashSet();
        this.n = new LinkedHashMap();
        this.o = new LinkedHashMap();
        this.p = new b(this);
    }

    public static int h(int r1) {
        Integer r2 = Integer.valueOf(r1);
        if (r2.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L12;
        return r2.intValue();
    L12:
        return i5.P();
    L5:
        r0 = false;
        goto L6
    }

    public final void g(boolean r12) {
        e0 r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        b0 r1 = this.h;
        if (r1 == null) goto L8;
        r1.a();
    L8:
        int r2 = a0.a;
        List<fn8.c> r3 = a0.a(r0.d, this.m);
        this.c = r3;
        this.d = e(r3, r0.f, r0.e);
        this.g = new d0(r0, this.b, this.c);
        u r4 = new u(r0.a, r0.b, r0.c, r0.d, this.b, this.c);
        if (r12 == false) goto L11;
        r4.m();
    L11:
        this.f = r4;
        List<fn8.x> r13 = d(r0, this.b);
        this.e = r13;
        if (r13.isEmpty() == true) goto L20;
        Iterator<T> r14 = r13.iterator();
    L16:
        if (r14.hasNext() == false) goto L20;
        if (((fn8.x) r14.next()).l == false) goto L16;
        boolean r15 = true;
    L21:
        if (r15 == false) goto L23;
        b0 r16 = new b0(r0.a, r0.b, this.b, this.c);
    L24:
        this.h = r16;
        return;
    L23:
        r16 = null;
    L20:
        r15 = false;
        goto L21
    }

    public static final fn8.c a(h0 r2, String r3) {
        Iterator<T> r4 = r2.c.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if (Intrinsics.areEqual(((fn8.c) r0).a, r3) == false) goto L4;
    L10:
        return (fn8.c) r0;
    L8:
        r0 = null;
        goto L10
    }

    public static final int b(h0 r2, String r3) {
        Iterator<fn8.c> r4 = r2.c.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r4.next().a, r3) == true) goto L13;
        r0 = r0 + 1;
        goto L4
    L13:
        return r0;
    L9:
        return -1;
    }

    public final void c(e0 r14, g0 r15) {
        Intrinsics.checkNotNullParameter(r14, "vmData");
        this.j++;
        Job r0 = this.i;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        b0 r1 = this.h;
        if (r1 == null) goto L8;
        r1.a();
    L8:
        f();
        this.a = r14;
        this.b = r15;
        int r2 = a0.a;
        List<fn8.c> r3 = a0.a(r14.d, SetsKt.emptySet());
        this.c = r3;
        this.d = e(r3, r14.f, r14.e);
        this.g = new d0(r14, r15, this.c);
        u r4 = new u(r14.a, r14.b, r14.c, r14.d, r15, this.c);
        r4.m();
        this.f = r4;
        List<fn8.x> r5 = d(r14, r15);
        this.e = r5;
        if (r5.isEmpty() == true) goto L17;
        Iterator<T> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        if (((fn8.x) r6.next()).l == false) goto L13;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L20;
        b0 r8 = new b0(r14.a, r14.b, r15, this.c);
    L21:
        this.h = r8;
        this.m.clear();
        if (r15.c() == null) goto L80;
        Iterator<T> r16 = r14.d.iterator();
    L26:
        if (r16.hasNext() == false) goto L80;
        RichMediaItem r17 = (RichMediaItem) r16.next();
        CreationItem r9 = r17.creation;
        if (r9 == null) goto L26;
        Integer r18 = r17.type;
        int r10 = RichMediaType.CREATION.getValue();
        if (r18 != null) goto L33;
    L50:
        boolean r19 = false;
    L51:
        if (r19 == true) goto L54;
        r9 = null;
    L54:
        if (r9 == null) goto L26;
        int r110 = a0.a;
        Intrinsics.checkNotNullParameter(r9, "creationItem");
        ImageData r111 = r9.image;
        if (r111 == null) goto L61;
        String r11 = r111.imageUri;
        if (r11 != null) goto L62;
        r11 = r111.key;
    L62:
        if (r11 == null) goto L26;
        if ((!StringsKt.isBlank(r11)) == true) goto L67;
        r11 = null;
    L67:
        if (r11 == null) goto L26;
        Long r112 = (Long) ((LinkedHashMap) this.o).get(r11);
        if (r112 != null) goto L71;
    L77:
        boolean r113 = CreationNoWatermarkManager.a.k0(r11);
    L78:
        if (r113 == false) goto L26;
        this.m.add(r11);
        goto L26
    L71:
        if ((System.currentTimeMillis() - r112.longValue()) >= 10000) goto L73;
        boolean r114 = true;
    L74:
        if (r114 == false) goto L76;
        r113 = false;
        goto L78
    L76:
        this.o.remove(r11);
        goto L77
    L73:
        r114 = false;
        goto L74
    L61:
        r11 = null;
        goto L62
    L33:
        if (r18.intValue() != r10) goto L50;
        Integer r115 = r9.type;
        if (r115 == null) goto L50;
        if (r115.intValue() != 1) goto L50;
        ImageData r116 = r9.image;
        if (r116 == null) goto L47;
        Integer r117 = r116.status;
        if (r117 == null) goto L47;
        if (r117.intValue() != 2) goto L47;
        boolean r118 = true;
    L48:
        if (r118 == false) goto L50;
        r19 = true;
    L47:
        r118 = false;
    L80:
        g(true);
        long r119 = this.j;
        Iterator r12 = CollectionsKt.toList(this.m).iterator();
    L82:
        if (r12.hasNext() == false) goto L93;
        String r13 = (String) r12.next();
        if (this.l.add(r13) == false) goto L82;
        f0 r20 = this.b;
        if (r20 == null) goto L89;
        CoroutineScope r21 = r20.c();
    L90:
        if (r21 == null) goto L91;
        this.n.put(r13, BuildersKt.launch$default(r21, null, null, new RichMediaLayoutViewModel$requestNoWatermarkImage$job$1(r119, this, r13, null), 3, null));
        goto L82
    L91:
        this.l.remove(r13);
        this.m.remove(r13);
        goto L82
    L89:
        r21 = null;
        goto L90
    L93:
        return;
    L20:
        r8 = null;
    L17:
        r7 = false;
        goto L18
    }

    public final List<fn8.x> d(e0 r38, f0 r39) {
        h0 r0 = this;
        if (r39 == null) goto L5;
        CoroutineScope r3 = r39.c();
    L6:
        if (r39 == null) goto L8;
        kc8.q r10 = r39.g();
    L10:
        if (r39 != null) goto L12;
    L14:
        boolean r13 = false;
    L15:
        List<fn8.c> r4 = r0.c;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r15 = r4.iterator();
        int r9 = 0;
    L17:
        if (r15.hasNext() == false) goto L191;
        Object r5 = r15.next();
        int r32 = r9 + 1;
        if (r9 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        fn8.c r8 = (fn8.c) r5;
        fn8.b r6 = r8.h;
        if ((r6 instanceof fn8.b.a) == false) goto L24;
        fn8.b.a r7 = (fn8.b.a) r6;
    L25:
        if (r7 == null) goto L27;
        CreationItem r11 = r7.a;
    L28:
        RichMediaKind r12 = r8.c;
        RichMediaKind r16 = RichMediaKind.IMAGE;
        if (r12 != r16) goto L33;
        if (r11 == null) goto L33;
        if (r3 == null) goto L33;
        p0 r17 = IRichMediaCreationClickService.a.e(r38.a, r11, r13, r10, r3);
    L34:
        RichMediaKind r18 = r8.c;
        RichMediaKind r19 = RichMediaKind.VIDEO;
        if (r18 != r19) goto L38;
        if (r11 == 0) goto L38;
        kc8.q0 r20 = IRichMediaCreationClickService.a.a(r38.a, r11, r13, r10);
    L39:
        int r21 = x.a;
        String r22 = r38.b;
        List<Size> r23 = r0.d;
        if (r9 >= 0) goto L42;
    L44:
        boolean r24 = false;
    L45:
        if (r24 == false) goto L47;
        Object r25 = ListProtector.get(r23, r9);
    L48:
        Size r26 = (Size) r25;
        String r27 = r38.a.getMessageId();
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r26, "itemSize");
        String r1 = r8.a;
        RichMediaKind r2 = r8.c;
        CoroutineScope r33 = r3;
        String r28 = r8.d;
        kc8.q r34 = r10;
        String r110 = r8.g;
        boolean r35 = r13;
        fn8.b r111 = r8.h;
        ArrayList r36 = r14;
        if ((r111 instanceof fn8.b.d) == false) goto L62;
        String r112 = ((fn8.b.d) r111).a.mainSiteUrl;
        if (r112 != null) goto L53;
    L61:
        String r29 = r110;
    L94:
        fn8.d0 r210 = null;
    L95:
        fn8.b r113 = r8.h;
        if ((r113 instanceof fn8.b.e) == false) goto L99;
        String r114 = ((fn8.b.e) r113).a.videoCaptions;
    L110:
        if (r114 != null) goto L112;
    L114:
        String r211 = null;
    L116:
        if (r8.i == false) goto L118;
        List r212 = CollectionsKt.emptyList();
        r26 = r26;
    L170:
        if (r20 == null) goto L175;
        if (r20.a != true) goto L175;
        boolean r213 = true;
    L176:
        RichMediaKind r30 = r8.c;
        if (r30 != r16) goto L179;
        boolean r214 = true;
    L180:
        boolean r31 = r8.h instanceof fn8.b.a;
        if (r31 == false) goto L184;
        if (r30 != r16) goto L184;
        boolean r37 = true;
    L185:
        if (r31 == false) goto L188;
        if (r30 != r16) goto L188;
        String r310 = r27 + ((fn8.b.a) r8.h).a.id + "true";
    L189:
        r36.add(new fn8.x(r1, r9, r22, r27, r2, r28, r26, r29, r210, r211, r212, r213, r214, r37, r310));
        r15 = r15;
        r14 = r36;
        r9 = r32;
        r3 = r33;
        r10 = r34;
        r13 = r35;
        r0 = this;
    L188:
        r310 = null;
    L184:
        r37 = false;
        goto L185
    L179:
        r214 = false;
    L175:
        r213 = false;
        goto L176
    L118:
        int r115 = r8.b;
        if (r115 != RichMediaType.CREATION.getValue()) goto L158;
        int r40 = x.a.a[r8.c.ordinal()];
        if (r40 != 1) goto L123;
        if (r17 != null) goto L141;
        List r41 = CollectionsKt.emptyList();
    L140:
        r26 = r26;
    L169:
        r212 = r41;
        goto L170
    L141:
        List r42 = CollectionsKt.createListBuilder();
        if (r17.a == false) goto L144;
        boolean r43 = false;
        r42.add(x.a(RichMediaItemAction.DOWNLOAD, RichMediaOverlayAlignment.START, 2131241239, false));
    L146:
        if (r17.b == false) goto L149;
        r42.add(x.a(RichMediaItemAction.SHARE, RichMediaOverlayAlignment.START, 2131242074, r43));
    L149:
        if (r17.e == false) goto L152;
        r42.add(x.a(RichMediaItemAction.CITE, RichMediaOverlayAlignment.END, 2131242848, r43));
    L157:
        r41 = CollectionsKt.build(r42);
        goto L169
    L152:
        if (r17.c == false) goto L155;
        r42.add(x.a(RichMediaItemAction.IMAGE_EDIT, RichMediaOverlayAlignment.END, 2131241146, r43));
    L155:
        if (r17.d == false) goto L157;
        r42.add(x.a(RichMediaItemAction.VIDEO_EDIT, RichMediaOverlayAlignment.END, 2131241148, r43));
        goto L157
    L144:
        r43 = false;
        goto L146
    L123:
        if (r40 != 2) goto L137;
        if (r20 != null) goto L126;
        r41 = CollectionsKt.emptyList();
        goto L140
    L126:
        List r44 = CollectionsKt.createListBuilder();
        if (r20.b == false) goto L130;
        r44.add(x.a(RichMediaItemAction.DOWNLOAD, RichMediaOverlayAlignment.START, 2131241239, true));
    L130:
        if (r20.c == false) goto L133;
        r44.add(x.a(RichMediaItemAction.CITE, RichMediaOverlayAlignment.END, 2131242848, false));
    L135:
        r41 = CollectionsKt.build(r44);
        goto L140
    L133:
        if (r20.d == false) goto L135;
        r44.add(new fn8.a(RichMediaItemAction.EXTEND, RichMediaOverlayAlignment.END, null, 2131905605, false, 20));
        goto L135
    L137:
        throw new NoWhenBranchMatchedException();
    L158:
        r26 = r26;
        if (r115 == RichMediaType.GENERIC_IMAGE.getValue()) goto L165;
        if (r115 == RichMediaType.GENERIC_VIDEO.getValue()) goto L165;
        r41 = CollectionsKt.emptyList();
    L165:
        if (r8.c != r19) goto L167;
        boolean r45 = true;
    L168:
        r41 = CollectionsKt.listOf(x.a(RichMediaItemAction.DOWNLOAD, RichMediaOverlayAlignment.START, 2131241239, r45));
        goto L169
    L167:
        r45 = false;
        goto L168
    L112:
        if ((!StringsKt.isBlank(r114)) == false) goto L114;
        r211 = r114;
        goto L116
    L99:
        if ((r113 instanceof fn8.b.d) == false) goto L101;
    L109:
        r114 = null;
        goto L110
    L101:
        if ((r113 instanceof fn8.b.a) == true) goto L109;
        if ((r113 instanceof fn8.b.C0108b) == true) goto L109;
        if ((r113 instanceof fn8.b.c) == true) goto L109;
        throw new NoWhenBranchMatchedException();
    L53:
        if (r112.length() <= 0) goto L55;
        boolean r116 = true;
    L56:
        if (r116 == true) goto L59;
        r112 = null;
    L59:
        if (r112 == null) goto L61;
        r29 = r110;
        r210 = new fn8.d0.b(r112, RichMediaOverlayAlignment.END);
        goto L95
    L55:
        r116 = false;
        goto L56
    L62:
        r29 = r110;
        if ((r111 instanceof fn8.b.e) == false) goto L86;
        fn8.b.e r117 = (fn8.b.e) r111;
        String r118 = r117.a.sourceAppIconV2;
        if (r118 != null) goto L67;
    L74:
        r118 = r117.a.sourceAppIcon;
        if (r118 != null) goto L77;
    L82:
        r118 = null;
    L83:
        if (r118 == null) goto L94;
        r210 = new fn8.d0.a(r118, RichMediaOverlayAlignment.START);
        goto L95
    L77:
        if (r118.length() <= 0) goto L79;
        boolean r119 = true;
    L80:
        if (r119 == false) goto L82;
    L79:
        r119 = false;
        goto L80
    L67:
        if (r118.length() <= 0) goto L69;
        boolean r120 = true;
    L70:
        if (r120 == true) goto L73;
        r118 = null;
    L73:
        if (r118 != null) goto L83;
    L69:
        r120 = false;
        goto L70
    L86:
        if ((r111 instanceof fn8.b.a) == true) goto L94;
        if ((r111 instanceof fn8.b.C0108b) == true) goto L94;
        if ((r111 instanceof fn8.b.c) == true) goto L94;
        throw new NoWhenBranchMatchedException();
    L47:
        r25 = new Size(0, 0);
        goto L48
    L42:
        if (r9 >= r23.size()) goto L44;
        r24 = true;
    L38:
        r20 = null;
    L33:
        r17 = null;
        goto L34
    L27:
        r11 = null;
        goto L28
    L24:
        r7 = null;
        goto L25
    L191:
        return r14;
    L12:
        if (r39.l() != true) goto L14;
        r13 = true;
        goto L15
    L8:
        r10 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static List e(List r9, int r10, boolean r11) {
        int r1 = 0;
        if (r11 == true) goto L5;
    L38:
        boolean r12 = false;
    L39:
        float r3 = 1.0f;
        if (r12 == false) goto L73;
        int r13 = h(r10);
        ArrayList r14 = new ArrayList();
        Iterator r5 = r9.iterator();
    L43:
        if (r5.hasNext() == false) goto L53;
        fn8.b r6 = ((fn8.c) r5.next()).h;
        if ((r6 instanceof fn8.b.a) == false) goto L47;
        fn8.b.a r7 = (fn8.b.a) r6;
    L48:
        if (r7 == null) goto L50;
        CreationItem r8 = r7.a;
    L51:
        if (r8 == null) goto L43;
        r14.add(r8);
        goto L43
    L50:
        r8 = null;
        goto L51
    L47:
        r7 = null;
        goto L48
    L53:
        ArrayList r15 = (ArrayList) r9;
        if (r14.size() != r15.size()) goto L102;
        Size r0 = IRichMediaCreationClickService.a.c((CreationItem) CollectionsKt.first(r14), r13, r14.size());
        if (r0 != null) goto L68;
        fn8.c r16 = (fn8.c) CollectionsKt.first(r9);
        int r17 = r14.size();
        int r2 = i5.a0();
        if (r17 != 1) goto L61;
        int r18 = r13;
    L62:
        int r19 = RangesKt.coerceAtLeast(Math.min(r2, r18), 1);
        int r110 = RangesKt.coerceAtLeast(Math.min(r13, i5.a0()), 1);
        int r4 = r16.e;
        if (r4 <= 0) goto L67;
        int r20 = r16.f;
        if (r20 <= 0) goto L67;
        r3 = r20 / r4;
    L67:
        r0 = i(r19, r110, r3);
        goto L68
    L61:
        r18 = MathKt.roundToInt(r13 * 0.8f);
    L68:
        int r21 = r15.size();
        ArrayList r111 = new ArrayList(r21);
    L69:
        if (r1 >= r21) goto L72;
        r111.add(r0);
        r1 = r1 + 1;
        goto L69
    L72:
        return r111;
    L102:
        return CollectionsKt.emptyList();
    L73:
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r22 = r9.iterator();
    L75:
        if (r22.hasNext() == false) goto L87;
        fn8.c r23 = (fn8.c) r22.next();
        int r24 = ((ArrayList) r9).size();
        int r25 = h(r10);
        int r26 = r23.e;
        if (r26 <= 0) goto L81;
        int r27 = r23.f;
        if (r27 <= 0) goto L81;
        float r28 = r27 / r26;
    L82:
        float r29 = RangesKt.coerceIn(r28, 0.5625f, 1.7777778f);
        if (r24 != 1) goto L85;
        int r30 = RangesKt.coerceAtLeast(Math.min(i5.a0(), MathKt.roundToInt(r25 * 0.8f)), 1);
        Size r31 = i(r30, r30, r29);
    L86:
        r112.add(r31);
        goto L75
    L85:
        int r32 = RangesKt.coerceAtLeast(Math.min(i5.a0(), MathKt.roundToInt((r25 * 0.8f) * 0.66f)), 1);
        r31 = new Size(RangesKt.coerceAtLeast(MathKt.roundToInt(r32 / r29), 1), r32);
    L81:
        r28 = 1.0f;
        goto L82
    L87:
        return r112;
    L5:
        if (((ArrayList) r9).isEmpty() == false) goto L8;
    L34:
        boolean r113 = false;
    L36:
        if (r113 == false) goto L38;
        r12 = true;
        goto L39
    L8:
        if (r9.isEmpty() == true) goto L35;
        Iterator r114 = r9.iterator();
    L12:
        if (r114.hasNext() == false) goto L35;
        fn8.b r33 = ((fn8.c) r114.next()).h;
        if ((r33 instanceof fn8.b.a) == false) goto L16;
        fn8.b.a r34 = (fn8.b.a) r33;
    L17:
        if (r34 == null) goto L32;
        CreationItem r35 = r34.a;
        if (r35 == null) goto L32;
        Integer r36 = r35.type;
        if (r36 != null) goto L25;
    L26:
        Integer r37 = r35.type;
        if (r37 == null) goto L32;
        if (r37.intValue() != 2) goto L32;
    L31:
        boolean r38 = true;
    L33:
        if (r38 == true) goto L12;
    L25:
        if (r36.intValue() == 1) goto L31;
    L32:
        r38 = false;
        goto L33
    L16:
        r34 = null;
    L35:
        r113 = true;
        goto L36
    }

    public static Size i(int r1, int r2, float r3) {
        int r0 = MathKt.roundToInt(r1 * r3);
        if (r0 <= r2) goto L5;
        r1 = MathKt.roundToInt(r2 / r3);
    L7:
        return new Size(RangesKt.coerceAtLeast(r1, 1), RangesKt.coerceAtLeast(r2, 1));
    L5:
        r2 = r0;
        goto L7
    }
}
