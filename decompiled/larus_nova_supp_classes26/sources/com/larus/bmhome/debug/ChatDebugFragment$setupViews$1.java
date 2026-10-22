package com.larus.bmhome.debug;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.debug.databinding.LarusPageChatDebugBinding;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextDescView;
import com.larus.business.debug.base.audio.module.ASRModule;
import com.larus.business.debug.base.audio.module.TTSModule;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.debug.ChatDebugFragment$setupViews$1", f = "ChatDebugFragment.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
final class ChatDebugFragment$setupViews$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatDebugFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ChatDebugFragment a;

        public a(ChatDebugFragment r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r2v6, types: [android.view.View, com.larus.bmhome.view.item.ItemTextDescView] */
        /* JADX WARN: Type inference failed for: r5v52, types: [android.view.ViewGroup, com.larus.bmhome.view.item.ItemTextArrow] */
        /* JADX WARN: Type inference failed for: r6v36, types: [android.view.View, android.view.ViewGroup, com.larus.bmhome.view.item.ItemTextArrow] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object emit(Object r23, Continuation r24) {
            ChatDebugViewModel.a r0 = (ChatDebugViewModel.a) r23;
            final ChatDebugFragment r2 = this.a;
            int r3 = ChatDebugFragment.k;
            r2.getClass();
            String r8 = "";
            if ((r0 instanceof ChatDebugViewModel.a.c) == false) goto L223;
            ChatDebugViewModel.a.c r1 = (ChatDebugViewModel.a.c) r0;
            final Message r4 = r1.a;
            final LarusPageChatDebugBinding r9 = r2.d;
            if (r9 == null) goto L220;
            ItemTextDescView r10 = r9.A;
            if (r4 == null) goto L9;
            String r11 = r4.getMessageId();
        L10:
            if (r11 != null) goto L12;
            r11 = "";
        L12:
            r10.setDescText(r11);
            if (r4 == null) goto L25;
            String r12 = Long.valueOf(r4.getCreateTime()).toString();
            if (r12 == null) goto L25;
            if (r12.length() <= 0) goto L19;
            boolean r13 = true;
        L20:
            if (r13 == true) goto L23;
            r12 = null;
        L23:
            if (r12 == null) goto L25;
            r9.y.setDescText(r12);
            r9.x.setDescText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(((long) GuidePriority.COMMERCE_CREDIT_PRIORITY) * CastLongProtector.parseLong(r12))));
            goto L25
        L19:
            r13 = false;
        L25:
            ItemTextDescView r5 = r9.D;
            if (r4 == null) goto L30;
            String r6 = Boolean.valueOf(r4.isNewBlockType()).toString();
            if (r6 == null) goto L30;
        L31:
            r5.setDescText(r6);
            if (r4 == null) goto L44;
            CopyOnWriteArraySet r7 = xc8.f.a;
            xc8.g r14 = xc8.f.c(r4);
            ItemTextDescView r15 = r9.H;
            StringBuilder r16 = new StringBuilder();
            if (r14 == null) goto L36;
            Integer r17 = Integer.valueOf(r14.c());
        L37:
            r16.append(r17);
            r16.append(": ");
            if (r14 == null) goto L40;
            String r18 = r14.getClass().getSimpleName();
        L41:
            if (r18 != null) goto L43;
            r18 = "";
        L43:
            r16.append(r18);
            r15.setDescText(r16.toString());
            goto L44
        L40:
            r18 = null;
            goto L41
        L36:
            r17 = null;
        L44:
            if (r4 == null) goto L56;
            String r19 = Long.valueOf(r4.getCreateTime()).toString();
            if (r19 == null) goto L56;
            if (r19.length() <= 0) goto L50;
            boolean r20 = true;
        L51:
            if (r20 == true) goto L54;
            r19 = null;
        L54:
            if (r19 == null) goto L56;
            r9.y.setDescText(r19);
            r9.x.setDescText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(CastLongProtector.parseLong(r19) * ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY))));
            goto L56
        L50:
            r20 = false;
        L56:
            if (r4 == null) goto L61;
            Map r21 = r4.getExt();
            if (r21 == null) goto L61;
            String r22 = (String) r21.get("bot_state");
            if (r22 == null) goto L61;
        L322:
            JSONObject r25 = new JSONObject(r22);     // Catch: JSONException -> L64
        L65:
            ItemTextDescView r26 = r9.b;
            if (r25 == null) goto L70;
            String r27 = r25.optString("agent_id");
            if (r27 == null) goto L70;
        L71:
            r26.setDescText(r27);
            ItemTextDescView r28 = r9.c;
            if (r25 == null) goto L76;
            String r29 = r25.optString("agent_name");
            if (r29 == null) goto L76;
        L77:
            r28.setDescText(r29);
            ItemTextDescView r30 = r9.C;
            if (r4 == null) goto L80;
            Boolean r31 = Boolean.valueOf(com.larus.im.bean.message.a.b0(r4));
        L81:
            r30.setDescText(String.valueOf(r31));
            r9.A.setOnClickListener(new f(r2, r9));
            r9.y.setOnClickListener(new j(r2, r9));
            r9.x.setOnClickListener(new k(r2, r9));
            if (r4 == null) goto L86;
            String r32 = com.larus.im.bean.message.a.x(r4);
            if (r32 == null) goto L86;
            r9.E.setDescText(r32);
            r9.E.setOnClickListener(new m(r2, r9));
        L86:
            if (r4 == null) goto L90;
            Map r33 = r4.getExt();
            if (r33 == null) goto L90;
            String r34 = (String) r33.get("asr_log_id");
        L91:
            if (r34 != null) goto L94;
            r34 = "";
        L94:
            if (r34.length() <= 0) goto L96;
            boolean r35 = true;
        L97:
            if (r35 == false) goto L99;
            e1.x(r9.t);
            r9.t.setDescText(r34);
            r9.t.setOnClickListener(new n(r2, r9));
        L100:
            r9.v.setOnClickListener(new o(r2, r9, r4));
            r9.G.setOnClickListener(new p(r2, r9, r4));
            r9.w.setOnClickListener(new q(r2, r9, r4));
            r9.B.setOnClickListener(new r(r2, r9, r4));
            r9.z.setOnClickListener(new s(r2, r9, r4));
            r9.F.setOnClickListener(new g(r2, r4, r9));
            r9.u.setOnClickListener(new h(r2, r4, r9));
            if (AuthModelDelegate.b.b() == false) goto L109;
            ConstraintLayout r36 = r9.B;
            if (r36 == null) goto L105;
            r36.setBackgroundResource(v19.c.b(2130970709, r36.getContext(), 2131239218));
        L105:
            r9.K.setVisibility(0);
            r9.L.setVisibility(0);
            r9.J.setVisibility(0);
            ConstraintLayout r37 = r9.J;
            if (r37 == null) goto L108;
            r37.setBackgroundResource(v19.c.b(2130970708, r37.getContext(), 2131239215));
        L108:
            r9.J.setOnClickListener(new i(r4, r9));
        L113:
            final LarusPageChatDebugBinding r38 = r2.d;
            if (r38 == null) goto L171;
            if (r4 != null) goto L118;
            e1.o(r38.e);
            e1.o(r38.O);
            goto L171
        L118:
            if (Intrinsics.areEqual(r4.getSenderId(), AccountService.a.getUserId()) == false) goto L140;
            m58.q r39 = m58.h.d;
            if (r39 == null) goto L127;
            ASRModule r40 = r39.c();
            if (r40 == null) goto L127;
            String r110 = r4.getLocalMessageId();
            if (r110 != null) goto L126;
            r110 = "";
        L126:
            final a68.a r41 = r40.d(r110);
        L128:
            if (r41 != null) goto L130;
            e1.o(r38.e);
            e1.o(r38.O);
            goto L171
        L130:
            String r42 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(r41.b()));
            r38.h.setText("ASR " + r42);
            e1.x(r38.e);
            e1.o(r38.O);
            e1.d(r38.f, new v(r2, r38, r41, r4));
            e1.d(r38.g, new x(r2, r38, r41, r4));
            String r43 = r41.a();
            if (r43 != null) goto L133;
        L136:
            boolean r44 = true;
        L137:
            if (r44 == false) goto L139;
            e1.o(r38.d);
            goto L171
        L139:
            e1.x(r38.d);
            e1.d(r38.d, new y(r2, r38, r41));
            goto L171
        L133:
            if (r43.length() == 0) goto L136;
            r44 = false;
        L127:
            r41 = null;
            goto L128
        L140:
            m58.q r45 = m58.h.d;
            if (r45 == null) goto L148;
            TTSModule r46 = r45.d();
            if (r46 == null) goto L148;
            String r111 = r4.getMessageId();
            if (r111 != null) goto L147;
            r111 = "";
        L147:
            final a68.c r47 = r46.d(r111);
        L149:
            if (r47 != null) goto L151;
            e1.o(r38.e);
            e1.o(r38.O);
            goto L171
        L151:
            String r48 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(r47.b()));
            r38.S.setText("TTS " + r48);
            e1.o(r38.e);
            e1.x(r38.O);
            e1.d(r38.Q, new z(r2, r38, r47, r4));
            e1.d(r38.R, new a0(r2, r38, r47, r4));
            String r49 = r47.a();
            if (r49 != null) goto L154;
        L157:
            boolean r50 = true;
        L158:
            if (r50 == false) goto L160;
            e1.o(r38.N);
        L161:
            String r51 = r47.c();
            if (r51 != null) goto L164;
        L167:
            boolean r52 = true;
        L168:
            if (r52 == false) goto L170;
            e1.o(r38.P);
            goto L171
        L170:
            e1.x(r38.P);
            e1.d(r38.P, new c0(r2, r38, r47));
            goto L171
        L164:
            if (r51.length() == 0) goto L167;
            r52 = false;
            goto L168
        L160:
            e1.x(r38.N);
            e1.d(r38.N, new b0(r2, r38, r47));
            goto L161
        L154:
            if (r49.length() == 0) goto L157;
            r50 = false;
        L148:
            r47 = null;
        L171:
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ChatDebugFragment$setupMessageInfo$1$19(r4, r9, null), 2, null);
            LarusPageChatDebugBinding r53 = r2.d;
            if (r53 == null) goto L176;
            final ?? r54 = r53.T;
            if (r54 == 0) goto L176;
            r54.setOnClickListener(new d0(r54));
        L176:
            if (r4 == null) goto L219;
            Keva r55 = Keva.getRepo("dora_tracer");
            if (TextUtils.isEmpty(r4.getReplyId()) == false) goto L181;
        L184:
            final String r56 = r55.getStringJustDisk(r4.getMessageId(), null);
        L186:
            if (TextUtils.isEmpty(r56) == true) goto L192;
            LarusPageChatDebugBinding r57 = r2.d;
            if (r57 == null) goto L197;
            final ?? r58 = r57.V;
            if (r58 == 0) goto L197;
            Intrinsics.checkNotNull(r56);
            int r59 = ItemTextArrow.k;
            r58.Z5(r56, null);
            e1.x(r58);
            r58.setOnClickListener(new e0(r58, r56));
        L197:
            String r60 = r55.getStringJustDisk("session_type_" + r56, null);
            if (r60 != null) goto L200;
        L203:
            boolean r61 = true;
        L204:
            if (r61 == true) goto L214;
            LarusPageChatDebugBinding r62 = r2.d;
            if (r62 == null) goto L219;
            ?? r63 = r62.U;
            if (r63 == 0) goto L219;
            e1.x(r63);
            if (r60 == null) goto L213;
            r8 = r60;
        L213:
            r63.setDescText(r8);
            goto L219
        L214:
            LarusPageChatDebugBinding r64 = r2.d;
            if (r64 == null) goto L219;
            ConstraintLayout r65 = r64.U;
            if (r65 == null) goto L219;
            e1.o(r65);
            goto L219
        L200:
            if (r60.length() == 0) goto L203;
            r61 = false;
            goto L204
        L192:
            LarusPageChatDebugBinding r66 = r2.d;
            if (r66 == null) goto L197;
            ConstraintLayout r67 = r66.V;
            if (r67 == null) goto L197;
            e1.o(r67);
            goto L197
        L181:
            if (Intrinsics.areEqual(r4.getReplyId(), TriggerSendLoading.NO_LOADING) == true) goto L184;
            r56 = r55.getStringJustDisk(r4.getReplyId(), null);
        L219:
            Unit r68 = Unit.INSTANCE;
            goto L220
        L109:
            ConstraintLayout r69 = r9.B;
            if (r69 == null) goto L112;
            r69.setBackgroundResource(v19.c.b(2130970708, r69.getContext(), 2131239215));
        L112:
            r9.K.setVisibility(8);
            r9.L.setVisibility(8);
            r9.J.setVisibility(8);
            goto L113
        L99:
            e1.o(r9.t);
            r9.t.setOnClickListener(null);
            goto L100
        L96:
            r35 = false;
        L90:
            r34 = null;
            goto L91
        L80:
            r31 = null;
        L76:
            r29 = "";
        L70:
            r27 = "";
        L64:
            r25 = null;
        L61:
            r22 = "";
        L30:
            r6 = "";
            goto L31
        L9:
            r11 = null;
        L220:
            Message r70 = r1.a;
            if (r70 == null) goto L319;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ChatDebugFragment$handleChatData$1$1(r70, null), 3, null);
        L319:
            return Unit.INSTANCE;
        L223:
            int r71 = 0;
            String r72 = null;
            if ((r0 instanceof ChatDebugViewModel.a.b) == false) goto L235;
            final wc9.e r73 = ((ChatDebugViewModel.a.b) r0).a;
            r2.h = r73;
            final LarusPageChatDebugBinding r74 = r2.d;
            if (r74 == null) goto L319;
            ItemTextDescView r75 = r74.p;
            if (r73 == null) goto L230;
            r72 = r73.a;
        L230:
            if (r72 == null) goto L233;
            r8 = r72;
        L233:
            r75.setDescText(r8);
            r74.p.setOnClickListener(new com.larus.bmhome.debug.a(r2, r74));
            r74.q.setOnClickListener(new l(r2, r74, r73));
            Unit r76 = Unit.INSTANCE;
            goto L319
        L235:
            if ((r0 instanceof ChatDebugViewModel.a.C0013a) == false) goto L321;
            final BotModel r77 = ((ChatDebugViewModel.a.C0013a) r0).a;
            r2.i = r77;
            final LarusPageChatDebugBinding r78 = r2.d;
            if (r78 == null) goto L319;
            ItemTextDescView r79 = r78.i;
            if (r77 == null) goto L241;
            String r80 = r77.getBotId();
        L242:
            if (r80 != null) goto L244;
            r80 = "";
        L244:
            r79.setDescText(r80);
            r78.i.setOnClickListener(new w(r2, r78));
            ConstraintLayout r81 = r78.k;
            if (r77 == null) goto L249;
            SpeakerVoice r82 = r77.getVoiceType();
            if (r82 == null) goto L249;
            String r83 = r82.getLanguage();
        L251:
            if (com.larus.utils.o0.d(r83) == false) goto L253;
            int r84 = 0;
        L254:
            r81.setVisibility(r84);
            ItemTextDescView r85 = r78.k;
            if (r77 == null) goto L259;
            SpeakerVoice r86 = r77.getVoiceType();
            if (r86 == null) goto L259;
            String r87 = r86.getLanguage();
        L260:
            if (r87 != null) goto L262;
            r87 = "";
        L262:
            r85.setDescText(r87);
            r78.k.setOnClickListener(new f0(r2, r78));
            ConstraintLayout r88 = r78.m;
            if (r77 == null) goto L267;
            SpeakerVoice r89 = r77.getVoiceType();
            if (r89 == null) goto L267;
            String r90 = r89.getLanguage();
        L269:
            if (com.larus.utils.o0.d(r90) == true) goto L279;
            if (r77 == null) goto L274;
            SpeakerVoice r91 = r77.getVoiceType();
            if (r91 == null) goto L274;
            String r92 = r91.getName();
        L276:
            if (com.larus.utils.o0.d(r92) == true) goto L279;
            boolean r93 = false;
        L280:
            if (r93 == false) goto L282;
            int r94 = 0;
        L283:
            r88.setVisibility(r94);
            ItemTextDescView r95 = r78.m;
            StringBuilder r96 = new StringBuilder();
            if (r77 == null) goto L288;
            SpeakerVoice r112 = r77.getVoiceType();
            if (r112 == null) goto L288;
            String r113 = r112.getLanguage();
        L289:
            if (r113 != null) goto L291;
            r113 = "";
        L291:
            r96.append(r113);
            r96.append(" - ");
            if (r77 == null) goto L296;
            SpeakerVoice r114 = r77.getVoiceType();
            if (r114 == null) goto L296;
            String r115 = r114.getName();
        L297:
            if (r115 != null) goto L299;
            r115 = "";
        L299:
            r96.append(r115);
            r95.setDescText(r96.toString());
            r78.m.setOnClickListener(new g0(r2, r78));
            ConstraintLayout r97 = r78.l;
            if (r77 == null) goto L304;
            ModelItem r98 = r77.getModel();
            if (r98 == null) goto L304;
            String r99 = r98.getName();
        L306:
            if (com.larus.utils.o0.d(r99) == true) goto L309;
            r71 = 8;
        L309:
            r97.setVisibility(r71);
            ItemTextDescView r100 = r78.l;
            if (r77 == null) goto L314;
            ModelItem r101 = r77.getModel();
            if (r101 == null) goto L314;
            r72 = r101.getName();
        L314:
            if (r72 == null) goto L317;
            r8 = r72;
        L317:
            r100.setDescText(r8);
            r78.l.setOnClickListener(new h0(r2, r78));
            r78.j.setOnClickListener(new i0(r2, r78, r77));
            Unit r102 = Unit.INSTANCE;
        L304:
            r99 = null;
        L296:
            r115 = null;
        L288:
            r113 = null;
            goto L289
        L282:
            r94 = 8;
        L274:
            r92 = null;
        L279:
            r93 = true;
        L267:
            r90 = null;
        L259:
            r87 = null;
            goto L260
        L253:
            r84 = 8;
        L249:
            r83 = null;
            goto L251
        L241:
            r80 = null;
            goto L242
        L321:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            ((IChatDebugExtItem) r2).priority();
            ((IChatDebugExtItem) r1).priority();
            return ComparisonsKt.compareValues(0, 0);
        }
    }

    public ChatDebugFragment$setupViews$1(ChatDebugFragment r1, Continuation<? super ChatDebugFragment$setupViews$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatDebugFragment$setupViews$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r22);
    L11:
        final ChatDebugFragment r3 = this.this$0;
        LarusPageChatDebugBinding r4 = r3.d;
        if (r4 == null) goto L14;
        r4.s.setOnClickListener(new t(r3));
        r4.r.setOnClickListener(new u());
        Unit r5 = Unit.INSTANCE;
    L14:
        ChatDebugFragment r6 = this.this$0;
        r6.getClass();
        if (z2.a.showNewTopicMainBotEnable() == false) goto L20;
        IAIChatService.Companion r7 = IAIChatService.a;
        final String[] r8 = r7.a8();
        final List r9 = r7.p7();
        String r10 = ArraysKt.joinToString$default(r8, "    ", "Tcc配置个数: " + r8.length + '\n', null, 0, null, new c(r8), 28, null);
        String r11 = CollectionsKt.joinToString$default(r9, "    ", "本地缓存个数" + r9.size() + ":\n", null, 0, null, new d(r9), 28, null);
        LarusPageChatDebugBinding r12 = r6.d;
        if (r12 == null) goto L20;
        r12.I.setText(r11 + "\n\n" + r10);
        r12.n.setOnClickListener(new e());
    L20:
        String r13 = (String) this.this$0.f.getValue();
        LarusPageChatDebugBinding r14 = this.this$0.d;
        if (r14 == null) goto L35;
        Iterator r15 = CollectionsKt.sortedWith(ServiceManager.get().getServices(IChatDebugExtItem.class, true), new b()).iterator();
    L24:
        if (r15.hasNext() == false) goto L35;
        IChatDebugExtItem r16 = (IChatDebugExtItem) r15.next();
        if (r16 == null) goto L30;
        View r17 = r16.b(r14.o.getContext(), r13);
        if (r17 == null) goto L30;
        r14.o.addView(r17);
    L30:
        if (r16 == null) goto L24;
        LinearLayout r18 = r16.a(r14.o.getContext(), r13);
        if (r18 == null) goto L24;
        r14.o.addView(r18);
    L35:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        Flow<ChatDebugViewModel.a> r19 = ((ChatDebugViewModel) this.this$0.e.getValue()).getChatDataFlow((String) this.this$0.f.getValue(), (String) this.this$0.g.getValue());
        a r20 = new a(this.this$0);
        this.label = 1;
        if (r19.collect(r20, this) != r1) goto L11;
        return r1;
    }
}
