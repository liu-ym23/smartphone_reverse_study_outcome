package com.larus.uaigc.music.lyrics_to_song;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.common.collect.Lists;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.adapter.f0;
import com.larus.bmhome.chat.adapter.h0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.showcase.x;
import com.larus.bmhome.music.widget.LyricsToSongCardView;
import com.larus.bmhome.music.widget.NestedRecyclerView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.im.bean.message.block.MusicCreationContentList;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.impl.databinding.LarusLyricsToSongListBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ic8.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kr8.u;
import kr8.v;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l extends com.larus.uaigc.music.lyrics_to_song.a implements te8.c {
    public SimpleLyricsToSongListAdapter q;
    public String r;
    public Message s;
    public q0.a t;
    public String u;
    public kr8.p v;
    public final HashMap<String, Integer> w;
    public final LarusLyricsToSongListBinding x;
    public Job y;

    public static final class a {
    }

    static {
    }

    public static /* synthetic */ void getMaxWidth$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getMaxWidth() {
        return com.larus.utils.i.d(getContext());
    }

    public final void onAttachedToWindow() {
        super/*com.larus.bmhome.chat.layout.item.i*/.onAttachedToWindow();
        Message r0 = this.s;
        Job r1 = null;
        if (r0 == null) goto L5;
        String r2 = com.larus.bmhome.chat.bean.d.x(r0).getOnboardingCardID();
    L7:
        if (o0.d(r2) == false) goto L9;
        String r3 = "onboarding_card_function_click";
    L10:
        String r6 = r3;
        if (TextUtils.isEmpty(this.u) == false) goto L24;
        Message r4 = this.s;
        if (r4 == null) goto L15;
        String r5 = r4.getMessageId();
    L16:
        String r7 = this.u;
        q0.a r8 = this.t;
        if (r8 == null) goto L22;
        y r9 = r8.u0();
        if (r9 == null) goto L22;
        String r10 = r9.getBotId();
        if (r10 == null) goto L22;
    L23:
        this.v = new kr8.p(r5, "1", r7, r6, "ai_generated", r10, 1);
    L42:
        Job r11 = this.y;
        if (r11 == null) goto L45;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L45:
        q0.a r12 = this.t;
        if (r12 == null) goto L50;
        LifecycleCoroutineScope r13 = r12.F9();
        if (r13 == null) goto L50;
        r1 = BuildersKt.launch$default(r13, null, null, new LyricsToSongListBox$collectScrollToPlayingCardEvent$1(this, null), 3, null);
    L50:
        this.y = r1;
        q0.a r14 = this.t;
        if (r14 == null) goto L56;
        u7 r15 = r14.u3();
        if (r15 == null) goto L57;
        r15.um(this);
        return;
    L57:
        return;
    L56:
        return;
    L22:
        r10 = "";
        goto L23
    L15:
        r5 = null;
        goto L16
    L24:
        u r16 = u.a;
        Message r17 = this.s;
        if (r17 == null) goto L27;
        String r18 = r17.getMessageId();
    L28:
        String r19 = u.a(r18, 1);
        Set r20 = v.a;
        Message r21 = this.s;
        if (r21 == null) goto L31;
        String r22 = r21.getMessageId();
    L32:
        String r23 = this.u;
        q0.a r24 = this.t;
        if (r24 == null) goto L38;
        y r25 = r24.u0();
        if (r25 == null) goto L38;
        String r26 = r25.getBotId();
        if (r26 == null) goto L38;
    L39:
        kr8.l r27 = v.a(new kr8.p(r22, "1", r23, r6, "ai_generated", r26, 1), r19);
        if (r27 == null) goto L42;
        kr8.l.a.b(r27, null, 3);
    L38:
        r26 = "";
        goto L39
    L31:
        r22 = null;
        goto L32
    L27:
        r18 = null;
        goto L28
    L9:
        r3 = "chat_action_bar";
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.LinearLayout*/.onDetachedFromWindow();
        q0.a r0 = this.t;
        if (r0 == null) goto L8;
        u7 r1 = r0.u3();
        if (r1 == null) goto L9;
        r1.mA(this);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "mContext");
        super(r11);
        this.r = "";
        this.u = "";
        this.w = new HashMap();
        View r12 = LayoutInflater.from(getContext()).inflate(2131562940, this, false);
        addView(r12);
        int r0 = 2131384158;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r12, 2131384158);
        if (r2 == null) goto L9;
        r0 = 2131385213;
        NestedRecyclerView r4 = ViewBindings.findChildViewById(r12, 2131385213);
        if (r4 == null) goto L9;
        this.x = new LarusLyricsToSongListBinding((LinearLayout) r12, r2, r4);
        r4.setLayoutParams(new LinearLayout.LayoutParams(getMaxWidth(), -2));
        r4.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        y6.f(r4, new j(this), null, 0.0f, new k(this), 61);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }

    public final void A(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void F1(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r3, "msg");
        e1.o(this.x.b);
        FLogger.a.i("LyricsToSongBox", "hide regen for send message ");
    }

    public final void N0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void Q(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "answer");
    }

    public final void p(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public void setMaxWidth(int r3) {
        FLogger.a.i("LyricsToSongBox", "override max width");
    }

    public final void v(List<Message> r2) {
        Intrinsics.checkNotNullParameter(r2, "messages");
    }

    public final void v1(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "answer");
    }

    public final void y0(String r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r3, "id");
        e1.o(this.x.b);
        FLogger.a.i("LyricsToSongBox", "hide regen for receive message ");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.uaigc.music.lyrics_to_song.a
    public final void n(Message r22, q0 r23, wc9.e r24, boolean r25, MusicCreationContentList r26, Fragment r27) {
        this.s = r22;
        this.t = r23.getProvider();
        if (r22 == null) goto L6;
        IAIChatUgcAIGCService.a.h0(this, r22, r23, r23.getProvider());
    L6:
        String r1 = this.r;
        if (r22 == null) goto L9;
        String r2 = r22.getMessageId();
    L10:
        boolean r3 = !Intrinsics.areEqual(r1, r2);
        if (r22 == null) goto L13;
        String r4 = r22.getMessageId();
    L14:
        this.r = r4;
        String r5 = "";
        if (r4 != null) goto L17;
        r4 = "";
    L17:
        if (r22 == null) goto L20;
        String r6 = r22.getContent();
        if (r6 == null) goto L20;
    L21:
        MusicCreationContentList r7 = com.larus.bmhome.music.protocol.a.b(r4, r6);
        if (r22 != null) goto L24;
    L26:
        boolean r8 = false;
    L27:
        boolean r9 = !r8;
        Map r10 = r7.getContentMap();
        if (r10 != null) goto L30;
        return;
    L30:
        FLogger.a.i("LyricsToSongBox", "parsed = " + r7);
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r12 = r10.entrySet().iterator();
    L32:
        if (r12.hasNext() == false) goto L42;
        Map.Entry r13 = (Map.Entry) r12.next();
        MusicCreationContent r14 = (MusicCreationContent) r13.getValue();
        if (r14 != null) goto L36;
    L38:
        boolean r15 = false;
    L40:
        if ((!r15) == false) goto L32;
        r11.put(r13.getKey(), r13.getValue());
        goto L32
    L36:
        if (r14.getMusicGenFailed() != true) goto L38;
        r15 = true;
        goto L40
    L42:
        FLogger.a.i("LyricsToSongBox", "listFiltered = " + r11);
        ArrayList<Pair<Integer, MusicCreationContent>> r16 = new ArrayList();
        Iterator r17 = r11.entrySet().iterator();
        int r18 = 0;
    L44:
        if (r17.hasNext() == false) goto L47;
        r16.add(TuplesKt.to(Integer.valueOf(r18), ((Map.Entry) r17.next()).getValue()));
        r18 = r18 + 1;
        goto L44
    L47:
        if ((!r11.isEmpty()) == false) goto L57;
        int r19 = r7.getTaskNumber();
        int r20 = 0;
    L49:
        if (r20 >= r19) goto L57;
        if (r16.size() > r20) goto L53;
        r16.add(TuplesKt.to(Integer.valueOf(r20), null));
    L56:
        r20 = r20 + 1;
        goto L49
    L53:
        if (r9 == false) goto L56;
        if (r20 <= 0) goto L56;
        ListProtector.set(r16, r20, TuplesKt.to(Integer.valueOf(r20), null));
    L57:
        FLogger.a.i("LyricsToSongBox", "mock loading mapIndexed = " + r16);
        if (r22 != null) goto L60;
    L62:
        boolean r21 = false;
    L63:
        if (r21 == false) goto L81;
        ArrayList r28 = new ArrayList();
        Iterator<Pair<Integer, MusicCreationContent>> r29 = r16.iterator();
    L66:
        if (r29.hasNext() == false) goto L80;
        Pair<Integer, MusicCreationContent> r30 = r29.next();
        Pair<Integer, MusicCreationContent> r31 = r30;
        if (com.larus.bmhome.music.protocol.a.a((MusicCreationContent) r31.getSecond()) == false) goto L77;
        MusicCreationContent r32 = (MusicCreationContent) r31.getSecond();
        if (r32 != null) goto L72;
    L74:
        boolean r33 = false;
    L75:
        if (r33 == true) goto L77;
        boolean r34 = true;
    L78:
        if (r34 == false) goto L66;
        r28.add(r30);
        goto L66
    L72:
        if (r32.getMusicGenFailed() != true) goto L74;
        r33 = true;
    L77:
        r34 = false;
        goto L78
    L80:
        ArrayList<Pair<Integer, MusicCreationContent>> r35 = Lists.b(r28);
        FLogger.a.i("LyricsToSongBox", "message Finished mapIndexed = " + r35);
        ArrayList<Pair<Integer, MusicCreationContent>> r110 = r35;
    L83:
        if (r110.isEmpty() == false) goto L103;
        Iterator r36 = r10.values().iterator();
    L86:
        if (r36.hasNext() == false) goto L95;
        Object r37 = r36.next();
        MusicCreationContent r38 = (MusicCreationContent) r37;
        if (r38 != null) goto L90;
    L92:
        boolean r39 = false;
    L93:
        if (r39 == false) goto L86;
    L96:
        MusicCreationContent r40 = (MusicCreationContent) r37;
        if (r40 == null) goto L100;
        String r41 = r40.getMusicGenFailedMsg();
        if (r41 == null) goto L100;
    L101:
        ListProtector.add(r110, 0, TuplesKt.to(0, new MusicCreationContent(true, r41)));
        FLogger.a.i("LyricsToSongBox", "mock message for failed tip");
    L100:
        r41 = "";
        goto L101
    L90:
        if (r38.getMusicGenFailed() != true) goto L92;
        r39 = true;
        goto L93
    L95:
        r37 = null;
    L103:
        u r42 = u.a;
        kr8.p r43 = this.v;
        if (r43 == null) goto L106;
        String r44 = r43.d();
    L107:
        kr8.p r45 = this.v;
        if (r45 == null) goto L112;
        String r46 = r45.e();
        if (r46 == null) goto L112;
        int r47 = CastIntegerProtector.parseInt(r46);
    L113:
        String r48 = u.a(r44, r47);
        if (r3 == false) goto L121;
        this.w.clear();
        this.u = "";
        kr8.p r49 = this.v;
        if (r49 == null) goto L120;
        kr8.l r50 = v.a(r49, r48);
        if (r50 == null) goto L120;
        kr8.l.a.b(r50, null, 3);
    L120:
        this.v = null;
    L121:
        Pair r51 = (Pair) CollectionsKt.firstOrNull(r110);
        if (r51 == null) goto L129;
        MusicCreationContent r52 = (MusicCreationContent) r51.getSecond();
        if (r52 == null) goto L129;
        String r53 = r52.getVid();
        if (r53 == null) goto L129;
        r5 = r53;
    L129:
        this.u = r5;
        if (this.v != null) goto L132;
    L139:
        SimpleLyricsToSongListAdapter r54 = this.q;
        if (r54 == null) goto L170;
        if (r3 == true) goto L170;
        ArrayList<Pair<Integer, MusicCreationContent>> r55 = r54.d;
        if (r55 != null) goto L145;
    L147:
        boolean r56 = false;
    L148:
        if (r56 == false) goto L170;
        SimpleLyricsToSongListAdapter r57 = this.q;
        if (r57 == null) goto L171;
        Intrinsics.checkNotNullParameter(r7, "parsed");
        Intrinsics.checkNotNullParameter(r110, "mapIndexed");
        r57.a = r22;
        r57.c = r9;
        r57.d = r110;
        Pair r58 = (Pair) CollectionsKt.firstOrNull(r110);
        if (r58 == null) goto L159;
        MusicCreationContent r59 = (MusicCreationContent) r58.getSecond();
        if (r59 == null) goto L159;
        ad9.b r60 = r59.getPlayList();
        if (r60 == null) goto L159;
        String r111 = r60.getItemId();
    L160:
        Iterator<SimpleLyricsToSongListViewHolder> r112 = r57.g.iterator();
    L162:
        if (r112.hasNext() == false) goto L171;
        final SimpleLyricsToSongListViewHolder r61 = r112.next();
        Integer r62 = r61.b;
        if (r62 == null) goto L171;
        Pair r63 = (Pair) ListProtector.get(r110, r62.intValue());
        SimpleLyricsToSongListAdapter r113 = r57;
        LyricsToSongCardView.j(r61.a, r22, r57.b, (MusicCreationContent) r63.getSecond(), ((Number) r63.getFirst()).intValue(), r111, null, new p(r61), 32);
        if (r22 == null) goto L168;
        IAIChatUgcAIGCService.a.h0(r61.a, r22, r113.e, r113.b);
    L168:
        r57 = r113;
    L159:
        r111 = null;
    L171:
        FLogger r64 = FLogger.a;
        r64.d("LyricsToSongBox", "-------------------------------------------------------------");
        final q0.a r65 = r23.getProvider();
        if (r22 == null) goto L274;
        final LarusLyricsToSongListBinding r66 = this.x;
        com.larus.bmhome.chat.component.regen.a r67 = r65.s5();
        if (r67 != null) goto L177;
    L179:
        boolean r68 = false;
    L181:
        if (r68 == true) goto L185;
        if (r22.getMessageStatusLocal() == 20) goto L185;
    L243:
        e1.o(r66.b);
        return;
    L185:
        if (com.larus.bmhome.chat.bean.d.z0(r22) == true) goto L243;
        if (r24 != null) goto L188;
    L190:
        boolean r69 = false;
    L191:
        if (r69 == true) goto L243;
        u7 r70 = r65.u3();
        if (r70 == null) goto L196;
        final MessageAdapter r71 = r70.MF();
    L197:
        if (r71 == null) goto L199;
        List r72 = r71.getCurrentList();
    L200:
        if (r71 == null) goto L202;
        String r73 = r71.C;
    L203:
        com.larus.bmhome.instruction.g r74 = r65.D9();
        if (r74 == null) goto L206;
        List r75 = r74.tq();
    L207:
        com.larus.bmhome.chat.component.collection.o r76 = r65.i2();
        if (r76 == null) goto L210;
        Boolean r77 = Boolean.valueOf(r76.i0());
    L211:
        x r114 = r65.G9();
        if (r114 == null) goto L214;
        Boolean r115 = Boolean.valueOf(r114.e6());
    L215:
        Intrinsics.checkNotNullParameter(r22, "<this>");
        if (r72 == null) goto L230;
        boolean r116 = true;
        if (z2.a.h1().b == true) goto L222;
        r116 = false;
    L222:
        if (r116 == false) goto L230;
        Message r78 = f0.c(r22, r72);
        if (r78 == null) goto L230;
        if (h0.f(r78, r73, r75, r77, r115) == true) goto L231;
        r64.i("MessageModifierExt", "getModifyToGenerateMsg msg can't modify " + r78.getMessageId());
        goto L230
    L231:
        final Message r117 = r78;
    L232:
        if (r117 == null) goto L242;
        if (r71 == null) goto L242;
        if (r22.getMessageStatusLocal() != 20) goto L238;
        e1.q(r66.b);
        return;
    L238:
        e1.x(r66.b);
        r66.b.setOnClickListener(new i(r117, r65, r66, r71));
        if (r25 == false) goto L241;
        r66.b.setAlpha(0.3f);
        return;
    L241:
        r66.b.setAlpha(1.0f);
        return;
    L242:
        r64.i("LyricsToSongBox", "regenerateBtn gone because modifyTargetMsg not valid");
        e1.o(r66.b);
        return;
    L230:
        r117 = null;
        goto L232
    L214:
        r115 = null;
        goto L215
    L210:
        r77 = null;
        goto L211
    L206:
        r75 = null;
        goto L207
    L202:
        r73 = null;
        goto L203
    L199:
        r72 = null;
        goto L200
    L196:
        r71 = null;
        goto L197
    L188:
        if (n.d(r24) != true) goto L190;
        r69 = true;
        goto L191
    L177:
        if (r67.tL(r22) != true) goto L179;
        r68 = true;
        goto L181
    L274:
        return;
    L145:
        if (r55.size() != r110.size()) goto L147;
        r56 = true;
    L170:
        SimpleLyricsToSongListAdapter r79 = new SimpleLyricsToSongListAdapter(r22, r23.getProvider(), r7, r9, r110, r23, this.w);
        this.q = r79;
        this.x.c.setAdapter(r79);
        this.x.c.setSwipeModel(r23.getProvider().O9());
        goto L171
    L132:
        if (TextUtils.isEmpty(r5) == true) goto L139;
        kr8.p r80 = this.v;
        if (r80 == null) goto L138;
        kr8.l r81 = v.a(kr8.p.c(r80, this.u), r48);
        if (r81 == null) goto L138;
        kr8.l.a.b(r81, null, 3);
    L138:
        this.v = null;
    L112:
        r47 = 1;
        goto L113
    L106:
        r44 = null;
        goto L107
    L81:
        r110 = r16;
        goto L83
    L60:
        if (com.larus.bmhome.chat.bean.d.j0(r22) != true) goto L62;
        r21 = true;
        goto L63
    L24:
        if (com.larus.bmhome.chat.bean.d.j0(r22) != true) goto L26;
        r8 = true;
    L20:
        r6 = "";
        goto L21
    L13:
        r4 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    }
}
