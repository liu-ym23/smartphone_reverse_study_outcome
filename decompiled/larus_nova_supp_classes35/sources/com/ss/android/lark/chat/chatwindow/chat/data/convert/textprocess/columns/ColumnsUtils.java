package com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns;

import android.content.Context;
import android.text.Layout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.preprocess.ElementExtra;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dcc.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import u2b.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ColumnsUtils {
    public static HashMap<String, HashMap<Integer, Layout>> a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/data/convert/textprocess/columns/ColumnsUtils$CalculateColumnsLayoutSceneInfo;", "Ljava/io/Serializable;", "messageId", BuildConfig.FLAVOR, "sceneTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "getSceneTag", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "component1", "component2", "copy", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CalculateColumnsLayoutSceneInfo implements Serializable {
        private final String messageId;
        private final String sceneTag;

        public static /* synthetic */ CalculateColumnsLayoutSceneInfo copy$default(CalculateColumnsLayoutSceneInfo r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.messageId;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.sceneTag;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.messageId;
        }

        public final String component2() {
            return this.sceneTag;
        }

        public final CalculateColumnsLayoutSceneInfo copy(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            Intrinsics.checkNotNullParameter(r3, "sceneTag");
            return new CalculateColumnsLayoutSceneInfo(r2, r3);
        }

        public int hashCode() {
            return (this.messageId.hashCode() * 31) + this.sceneTag.hashCode();
        }

        public String toString() {
            return "CalculateColumnsLayoutSceneInfo(messageId='" + this.messageId + "', sceneTag='" + this.sceneTag + "')";
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final String getSceneTag() {
            return this.sceneTag;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(CalculateColumnsLayoutSceneInfo.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns.ColumnsUtils.CalculateColumnsLayoutSceneInfo");
            CalculateColumnsLayoutSceneInfo r6 = (CalculateColumnsLayoutSceneInfo) r5;
            if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.sceneTag, r6.sceneTag) == true) goto L18;
            return false;
        L18:
            return true;
        L8:
            r2 = null;
            goto L10
        }

        public CalculateColumnsLayoutSceneInfo(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            Intrinsics.checkNotNullParameter(r3, "sceneTag");
            this.messageId = r2;
            this.sceneTag = r3;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(RichText r10, b r11, Context r12, w2b.b r13, CalculateColumnsLayoutSceneInfo r14) {
        Intrinsics.checkNotNullParameter(r11, "processParams");
        Intrinsics.checkNotNullParameter(r12, "context");
        if (r10 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r11, "processParams");
        String r0 = r14.getMessageId();
        String r1 = BuildConfig.FLAVOR;
        if (r0 != null) goto L8;
        r0 = BuildConfig.FLAVOR;
    L8:
        String r15 = r14.getSceneTag();
        if (r15 == null) goto L12;
        r1 = r15;
    L12:
        List r16 = r10.getElementIds();
        Map r17 = r10.getElements().getDictionary();
        Intrinsics.checkNotNull(r16);
        Iterator r18 = r16.iterator();
    L14:
        if (r18.hasNext() == false) goto L18;
        String r2 = (String) r18.next();
        RichTextElement r3 = (RichTextElement) r17.get(r2);
        if (r3 == null) goto L14;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNull(r17);
        b(r2, r3, r17, r0, r1, r13, r11, r12);
        goto L14
    }

    public static void b(String r30, RichTextElement r31, Map r32, String r33, String r34, w2b.b r35, b r36, Context r37) {
        Map r8 = r32;
        if (r31.getTag() != RichTextElement.RichTextTag.COLUMNS) goto L99;
        String r2 = "ColumnsUtils";
        Log.i("ColumnsUtils", "message id = " + r33 + ", sceneTag = " + r34);
        StringBuilder r1 = new StringBuilder("columns id = ");
        r1.append(r30);
        Log.i("ColumnsUtils", r1.toString());
        HashMap<Integer, Layout> r3 = new HashMap();
        b.InterfaceC0038b r4 = r36.G;
        if (r4 == null) goto L7;
        Integer r5 = r4.a();
    L9:
        switch(r36.x) {
            case 17: goto L18;
            case 18: goto L17;
            case 19: goto L16;
            case 20: goto L15;
            case 21: goto L14;
            case 22: goto L13;
            case 23: goto L12;
            case 24: goto L11;
            default: goto L10;
        };
    L10:
        int r6 = Integer.MAX_VALUE;
    L19:
        LinkedList r7 = new LinkedList();
        List r9 = r31.getChildIds();
        Intrinsics.checkNotNull(r9);
        List r10 = r9;
        Iterator r11 = r10.iterator();
        int r13 = 0;
    L20:
        String r12 = "column id = ";
        if (r11.hasNext() == false) goto L33;
        String r14 = (String) r11.next();
        RichTextElement r16 = (RichTextElement) r8.get(r14);
        if (r16 == null) goto L25;
        RichTextElement.RichTextTag r15 = r16.getTag();
    L27:
        if (r15 != RichTextElement.RichTextTag.COLUMN) goto L20;
        Log.i("ColumnsUtils", "column id = " + r14);
        if (r16.getProperty().getWidth() > 0) goto L31;
        int r17 = 100;
    L32:
        r13 = r13 + r17;
        r7.add(Integer.valueOf(r17));
        goto L20
    L31:
        r17 = r16.getProperty().getWidth();
        goto L32
    L25:
        r15 = null;
        goto L27
    L33:
        int r18 = UIHelper.px2dp(r6);
        boolean r19 = a.a(r7, r18);
        float r110 = r18 - ((r7.size() - 1) * 6.0f);
        Iterator r20 = r10.iterator();
        int r111 = 0;
    L35:
        if (r20.hasNext() == false) goto L93;
        String r112 = (String) r20.next();
        RichTextElement r113 = (RichTextElement) r8.get(r112);
        if (r113 == null) goto L39;
        RichTextElement.RichTextTag r21 = r113.getTag();
    L41:
        if (r21 != RichTextElement.RichTextTag.COLUMN) goto L91;
        Log.i(r2, r12 + r112);
        List r0 = r113.getChildIds();
        if (r113.getProperty().getWidth() > 0) goto L45;
        int r22 = 100;
    L46:
        float r23 = r22 / r13;
        if (r19 == false) goto L49;
        Number r24 = Integer.valueOf(r18);
    L50:
        Intrinsics.checkNotNull(r0);
        int r114 = r24.intValue();
        Intrinsics.checkNotNullParameter(r0, "columnsCellChildIds");
        Intrinsics.checkNotNullParameter(r8, "elementMap");
        Intrinsics.checkNotNullParameter(r36, "processParams");
        RichText r25 = new RichText();
        RichText.RichTextElements r26 = new RichText.RichTextElements();
        HashMap r27 = new HashMap();
        ArrayList r115 = new ArrayList();
        int r116 = r0.size();
        int r28 = 0;
    L51:
        if (r28 >= r116) goto L86;
        int r29 = r116;
        String r117 = (String) ListProtector.get(r0, r28);
        HashMap<Integer, Layout> r210 = r3;
        RichTextElement r38 = (RichTextElement) r8.get(r117);
        r27.put(r117, r38);
        int r211 = r111;
        if (r38 != null) goto L55;
    L61:
        if (r38 == null) goto L63;
        List r39 = r38.getChildIds();
    L64:
        List r118 = r39;
        if (r118 != null) goto L67;
    L70:
        boolean r119 = true;
    L71:
        if (r119 == true) goto L85;
        int r120 = r118.size();
        int r121 = 0;
    L73:
        if (r121 >= r120) goto L85;
        String r122 = (String) ListProtector.get(r39, r121);
        List r212 = r39;
        RichTextElement r40 = (RichTextElement) r8.get(r122);
        r27.put(r122, r40);
        if (r40 == null) goto L84;
        if (r40.getTag() != RichTextElement.RichTextTag.IMG) goto L80;
        Intrinsics.checkNotNull(r122);
        r115.add(r122);
    L80:
        if (r40.getTag() != RichTextElement.RichTextTag.CODE_BLOCK_V2) goto L82;
        r36.y = UIHelper.dp2px(r114 - 1);
    L82:
        ElementExtra r41 = r40.getElementExtra();
        r41.setInColumnsCell(true);
        r41.setColumnsCellMaxWidth(r114);
    L84:
        r121 = r121 + 1;
        r8 = r32;
        r120 = r120;
        r39 = r212;
    L85:
        r28 = r28 + 1;
        r8 = r32;
        r111 = r211;
        r116 = r29;
        r3 = r210;
        goto L51
    L67:
        if (r118.isEmpty() == true) goto L70;
        r119 = false;
        goto L71
    L63:
        r39 = null;
        goto L64
    L55:
        if (r38.getTag() != RichTextElement.RichTextTag.IMG) goto L58;
        r115.add(r117);
    L58:
        if (r38.getTag() != RichTextElement.RichTextTag.CODE_BLOCK_V2) goto L60;
        r36.y = UIHelper.dp2px(r114);
    L60:
        ElementExtra r123 = r38.getElementExtra();
        r123.setInColumnsCell(true);
        r123.setColumnsCellMaxWidth(r114);
        goto L61
    L86:
        HashMap<Integer, Layout> r213 = r3;
        int r214 = r111;
        r26.setDictionary(r27);
        r25.setElementIds(r0);
        r25.setElements(r26);
        r25.setImageIds(r115);
        r36.M = UIHelper.dp2px(r24.floatValue());
        r36.N = r18;
        if (r35 == null) goto L89;
        Layout r42 = TextLayoutRenderExtKt.e(r35, r25, r36, r37);
    L90:
        HashMap<Integer, Layout> r43 = r213;
        r43.put(Integer.valueOf(r214), r42);
        r111 = r214 + 1;
    L92:
        r8 = r32;
        r3 = r43;
        r2 = r2;
        r20 = r20;
        r12 = r12;
        r19 = r19;
        r13 = r13;
        r7 = r7;
        r110 = r110;
        goto L35
    L89:
        int r44 = TextLayoutRender.j;
        r42 = TextLayoutRenderExtKt.e(w2b.b.d, r25, r36, r37);
        goto L90
    L49:
        r24 = Float.valueOf(r23 * r110);
        goto L50
    L45:
        r22 = r113.getProperty().getWidth();
        goto L46
    L91:
        r43 = r3;
        goto L92
    L39:
        r21 = null;
        goto L41
    L93:
        HashMap<Integer, Layout> r45 = r3;
        r7.clear();
        if (a != null) goto L96;
        a = new HashMap();
    L96:
        HashMap<String, HashMap<Integer, Layout>> r46 = a;
        if (r46 == null) goto L105;
        HashMap<Integer, Layout> r47 = r46.put(r30, r45);
        return;
    L105:
        return;
    L11:
        r6 = j.f(r37, r5);
        goto L19
    L12:
        r6 = j.j(r37, r36.g, r5, r36.a0);
        goto L19
    L13:
        r6 = j.i(r37, r36.g, r5, r36.a0);
        goto L19
    L14:
        r6 = j.l(r37, r5);
        goto L19
    L15:
        r6 = j.k(r37, r5);
        goto L19
    L16:
        r6 = j.e(r37, r5, r36.a0, r36.g);
        goto L19
    L17:
        r6 = j.b(r37, r5);
        goto L19
    L18:
        r6 = j.d(r37, r5);
        goto L19
    L7:
        r5 = null;
        goto L9
    L99:
        Iterator r48 = r31.getChildIds().iterator();
    L101:
        if (r48.hasNext() == false) goto L125;
        String r49 = (String) r48.next();
        RichTextElement r50 = (RichTextElement) r32.get(r49);
        if (r50 == null) goto L101;
        Intrinsics.checkNotNull(r49);
        b(r49, r50, r32, r33, r34, r35, r36, r37);
        goto L101
    }
}
