package com.obric.assistant.chat.component.skill;

import android.text.SpannableString;
import android.text.style.ClickableSpan;
import com.google.gson.Gson;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockType;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.obric_action.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import paa.e;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0002+,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J \u0010\u001b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0014\u0010\u001f\u001a\u00020\f*\u00020\u00142\u0006\u0010 \u001a\u00020\u0019H\u0002J$\u0010!\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0002J\"\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010#\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0002J\u001a\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006-"}, d2 = {"Lcom/obric/assistant/chat/component/skill/ObricUserTextCellInteractiveSpanComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/bmhome/chat/list/IUserTextCellInteractiveSpanAbility;", "<init>", "()V", "skillAbility", "Lcom/obric/assistant/ability/chat/input/IObricInputSkillAbility;", "getSkillAbility", "()Lcom/obric/assistant/ability/chat/input/IObricInputSkillAbility;", "skillAbility$delegate", "Lkotlin/Lazy;", "processInteractiveSpan", NameKeys.UnloadStrategy_No_Strategy, "textView", "Landroid/widget/TextView;", "message", "Lcom/larus/im/bean/message/Message;", LynxAccessibilityModule.MSG_CONTENT, NameKeys.UnloadStrategy_No_Strategy, "spannableText", "Landroid/text/SpannableString;", "parseSkillIds", NameKeys.UnloadStrategy_No_Strategy, "raw", "findMentionRanges", "Lcom/obric/assistant/chat/component/skill/ObricUserTextCellInteractiveSpanComponent$SpanRange;", "mentionText", "isMentionBoundary", "start", NameKeys.UnloadStrategy_No_Strategy, "end", "hasClickableSpan", "range", "buildSkillClickableSpan", "Lcom/larus/bmhome/chat/layout/widget/LongClickableSpan;", "routeUrl", "blockId", "openSkillPage", NameKeys.UnloadStrategy_No_Strategy, "widget", "Landroid/view/View;", "createSkillDetailRouteUrl", "skillId", "SpanRange", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUserTextCellInteractiveSpanComponent extends ComponentFeature implements jf8.a {
    public static final /* synthetic */ int i = 0;
    public final Lazy h;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "SpanRange(start=" + this.a + ", endExclusive=" + this.b + ')';
        }

        public b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements Function0<paa.c> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(paa.c.class));
        }
    }

    static {
    }

    public ObricUserTextCellInteractiveSpanComponent() {
        this.h = LazyKt.lazy(new c(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r0v68 */
    public final boolean De(CustomMarkdownTextView r22, Message r23, String r24, SpannableString r25) {
        Intrinsics.checkNotNullParameter(r22, "textView");
        Intrinsics.checkNotNullParameter(r23, "message");
        Intrinsics.checkNotNullParameter(r24, LynxAccessibilityModule.MSG_CONTENT);
        Intrinsics.checkNotNullParameter(r25, "spannableText");
        String r13 = null;
        if (StringsKt.contains$default(r24, '@', false, 2, null) == true) goto L5;
        return false;
    L5:
        Map r0 = r23.getExt();
        if (r0 == null) goto L8;
        String r3 = (String) r0.get("o_omni_init_skill_ids");
    L10:
        if (r3 != null) goto L12;
    L15:
        boolean r1 = true;
    L17:
        if (r1 == false) goto L146;
        List r2 = CollectionsKt.emptyList();
    L46:
        List r4 = CollectionsKt.distinct(r2);
        if (r4.isEmpty() == false) goto L49;
        return false;
    L49:
        paa.c r5 = (paa.c) this.h.getValue();
        if (r5 == null) goto L52;
        List<e> r6 = r5.dj();
    L53:
        if (r6 != null) goto L55;
        r6 = CollectionsKt.emptyList();
    L55:
        List<e> r7 = r6;
        LinkedHashMap r15 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16));
        Iterator r8 = r7.iterator();
    L57:
        if (r8.hasNext() == false) goto L59;
        Object r9 = r8.next();
        r15.put(((e) r9).a, r9);
        goto L57
    L59:
        Iterator r16 = r4.iterator();
        boolean r10 = false;
    L61:
        if (r16.hasNext() == false) goto L145;
        String r11 = (String) r16.next();
        e r12 = (e) r15.get(r11);
        if (r12 == null) goto L66;
        String r14 = r12.b;
        if (r14 == null) goto L66;
    L67:
        String r17 = "@" + r14;
        ArrayList r18 = new ArrayList();
        int r19 = 0;
    L69:
        if (r19 >= r24.length()) goto L94;
        ArrayList r110 = r18;
        String r111 = r11;
        int r20 = StringsKt.indexOf$default(r24, r17, r19, false, 4, null);
        if (r20 < 0) goto L95;
        r19 = r20 + r17.length();
        if (r20 != 0) goto L76;
    L79:
        boolean r21 = true;
    L81:
        if (r19 != r24.length()) goto L83;
    L86:
        boolean r26 = true;
    L87:
        if (r21 == false) goto L90;
        if (r26 == false) goto L90;
        boolean r27 = true;
    L91:
        if (r27 == false) goto L93;
        r110.add(new b(r20, r19));
    L93:
        r18 = r110;
        r11 = r111;
    L90:
        r27 = false;
        goto L91
    L83:
        if (CharsKt.isWhitespace(r24.charAt(r19)) == true) goto L86;
        r26 = false;
        goto L87
    L76:
        if (CharsKt.isWhitespace(r24.charAt(r20 - 1)) == true) goto L79;
        r21 = false;
    L95:
        Iterator r28 = r110.iterator();
    L97:
        if (r28.hasNext() == false) goto L61;
        b r29 = (b) r28.next();
        if (r25.getSpans(r29.a, r29.b, ClickableSpan.class).length != 0) goto L101;
        boolean r30 = true;
    L103:
        if ((!r30) == true) goto L143;
        Iterator r31 = ((ArrayList) com.larus.im.bean.message.a.A(r23)).iterator();
    L107:
        if (r31.hasNext() == false) goto L114;
        Object r32 = r31.next();
        if (((Block) r32).getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L111;
        boolean r33 = true;
    L112:
        if (r33 == false) goto L107;
    L115:
        Block r34 = (Block) r32;
        if (r34 == null) goto L118;
        String r35 = r34.getBlockId();
    L119:
        j.a.getClass();
        if (r111 != null) goto L122;
    L138:
        String r36 = null;
    L139:
        if (r36 != null) goto L141;
        String r37 = NameKeys.UnloadStrategy_No_Strategy;
    L142:
        r25.setSpan(new fda.b(r37, this, r35, r22), r29.a, r29.b, 33);
        r10 = true;
        goto L143
    L141:
        r37 = com.obric.assistant.obric_action.c.a().b(com.obric.assistant.obric_action.d.l.a.a, r36, com.obric.assistant.obric_action.c.a().c("obric_skill_detail", r35));
        goto L142
    L122:
        if ((!StringsKt.isBlank(r111)) == false) goto L124;
        String r38 = r111;
    L125:
        if (r38 == null) goto L138;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L129
        Gson r40 = (Gson) j.b.getValue();     // Catch: Throwable -> L129
        JSONObject r41 = new JSONObject();     // Catch: Throwable -> L129
        r41.put("previous_page", "chat");     // Catch: Throwable -> L129
        r41.put("enter_method", "obric_omni_click_skill_link_detail");     // Catch: Throwable -> L129
        Object r42 = Result.constructor-impl(r40.toJson(new j.a(r38, r41.toString())));     // Catch: Throwable -> L129
    L131:
        Throwable r43 = Result.exceptionOrNull-impl(r42);
        if (r43 == null) goto L135;
        FLogger.a.w("ObricSkillDetailActionUtils", "buildData failed. " + r43.getMessage(), r43);
    L135:
        if (Result.isFailure-impl(r42) == false) goto L137;
        r42 = null;
    L137:
        r36 = (String) r42;
    L129:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r42 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L131
    L124:
        r38 = r13;
        goto L125
    L118:
        r35 = r13;
        goto L119
    L111:
        r33 = false;
        goto L112
    L114:
        r32 = r13;
    L143:
        r13 = null;
        goto L97
    L101:
        r30 = false;
        goto L103
    L94:
        r110 = r18;
        r111 = r11;
    L66:
        r14 = r11;
        goto L67
    L145:
        return r10;
    L52:
        r6 = null;
        goto L53
    L146:
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L30
        JSONArray r46 = new JSONArray(r3);     // Catch: Throwable -> L30
        int r47 = r46.length();     // Catch: Throwable -> L30
        ArrayList r48 = new ArrayList(r47);     // Catch: Throwable -> L30
        int r49 = 0;
    L20:
        if (r49 >= r47) goto L22;
        r48.add(r46.optString(r49));     // Catch: Throwable -> L30
        r49 = r49 + 1;     // Catch: Throwable -> L30
        goto L20
    L22:
        ArrayList r50 = new ArrayList();     // Catch: Throwable -> L30
        Iterator r51 = r48.iterator();     // Catch: Throwable -> L30
    L24:
        if (r51.hasNext() == false) goto L28;
        Object r52 = r51.next();     // Catch: Throwable -> L30
        String r53 = (String) r52;     // Catch: Throwable -> L30
        Intrinsics.checkNotNull(r53);     // Catch: Throwable -> L30
        if ((!StringsKt.isBlank(r53)) == false) goto L24;
        r50.add(r52);     // Catch: Throwable -> L30
        goto L24
    L28:
        ?? r54 = Result.constructor-impl(r50);     // Catch: Throwable -> L30
    L33:
        if (Result.exceptionOrNull-impl(r54) == null) goto L45;
        FLogger.a.w("ObricUserTextCellInteractiveSpanComponent", "parseSkillIds failed, raw=" + r3);
        List r55 = StringsKt.split$default(StringsKt.removeSuffix(StringsKt.removePrefix(r3, "["), "]"), new String[]{","}, false, 0, 6, null);
        ArrayList r56 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r55, 10));
        Iterator r57 = r55.iterator();
    L37:
        if (r57.hasNext() == false) goto L39;
        r56.add(StringsKt.trim((String) r57.next()).toString());
        goto L37
    L39:
        r54 = new ArrayList();
        Iterator r58 = r56.iterator();
    L41:
        if (r58.hasNext() == false) goto L45;
        Object r59 = r58.next();
        if ((!StringsKt.isBlank((String) r59)) == false) goto L41;
        r54.add(r59);
    L45:
        r2 = (List) r54;
    L30:
        th = move-exception;
        Result.Companion r60 = Result.Companion;
        r54 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L12:
        if (StringsKt.isBlank(r3) == true) goto L15;
        r1 = false;
        goto L17
    L8:
        r3 = null;
        goto L10
    }
}
