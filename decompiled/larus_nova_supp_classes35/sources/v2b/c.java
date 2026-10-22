package v2b;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns.ColumnsUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.columns.ColumnsProcessParams;
import com.ss.android.lark.widget.light.processor.c0;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.i;
import com.ss.android.lark.widget.span.AbbreviationInfo;
import com.ss.android.lark.widget.span.PhoneInfo;
import com.ss.android.lark.widget.span.PrefixSpanStyle;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.UrlInfo;
import com.ss.android.lark.widget.span.d0;
import com.ss.android.lark.widget.span.g0;
import com.ss.android.lark.widget.table.TableProcessParams;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final CharSequence a(RichText r48, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r49, Context r50, int r51) {
        Intrinsics.checkNotNullParameter(r48, "oriRichText");
        Intrinsics.checkNotNullParameter(r49, "processParams");
        Intrinsics.checkNotNullParameter(r50, "context");
        int r5 = TextLayoutRender.j;
        w2b.b r6 = w2b.b.d;
        String r7 = r49.p;
        if (r7 != null) goto L5;
        r7 = BuildConfig.FLAVOR;
    L5:
        TableUtils.a(r48, r49, r50, r6, new TableUtils.CalculateTableLayoutSceneInfo(r7, "RichTextConvertCharSequenceUtil"));
        ColumnsUtils.a(r48, r49, r50, r6, new ColumnsUtils.CalculateColumnsLayoutSceneInfo(r7, "RichTextConvertCharSequenceUtil"));
        r49.H = TableUtils.a;
        r49.I = ColumnsUtils.a;
        char[] r8 = h.a;
        Intrinsics.checkNotNullParameter(r48, "<this>");
        Iterator r9 = r48.getElements().getDictionary().entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L27;
        RichTextElement r10 = (RichTextElement) ((Map.Entry) r9.next()).getValue();
        RichTextElement.RichTextTag r11 = r10.getTag();
        if (r11 != null) goto L11;
        int r12 = -1;
    L12:
        char[] r13 = h.a;
        if (r12 != 1) goto L15;
        RichTextElement.AtProperty r14 = r10.getProperty();
        r14.setContent(h.a(r14.getContent()));
        goto L7
    L15:
        if (r12 != 2) goto L17;
        RichTextElement.AnchorProperty r15 = r10.getProperty();
        r15.setContent(h.a(r15.getContent()));
        r15.setHref(h.a(r15.getHref()));
        String r16 = r15.getAndroidHref();
        if (r16 == null) goto L23;
        String r17 = h.a(r16);
    L24:
        r15.setAndroidHref(r17);
        goto L7
    L23:
        r17 = null;
        goto L24
    L17:
        if (r12 != 3) goto L7;
        RichTextElement.TextProperty r18 = r10.getProperty();
        r18.setContent(h.a(r18.getContent()));
        goto L7
    L11:
        r12 = h.a.a[r11.ordinal()];
        goto L12
    L27:
        if (r49.x != 19) goto L29;
        int r19 = 1;
    L31:
        if (CollectionUtils.isNotEmpty(r48.getImageIds()) == false) goto L33;
    L36:
        boolean r20 = true;
    L37:
        r49.j = r20;
        int r21 = r49.x;
        if (r21 == 18) goto L43;
        if (r21 == 20) goto L43;
        if (r21 == 21) goto L43;
        boolean r22 = false;
    L45:
        if (r49.i == false) goto L69;
        if (r22 == false) goto L48;
        r19 = 5;
    L49:
        Intrinsics.checkNotNullParameter(r50, "context");
        if (r22 == false) goto L69;
        if (i.l(r48) == true) goto L69;
        Iterator r110 = r48.getElements().getDictionary().values().iterator();
    L56:
        if (r110.hasNext() == false) goto L69;
        RichTextElement r111 = (RichTextElement) r110.next();
        if (r111 == null) goto L56;
        if (r111.getTag() != RichTextElement.RichTextTag.IMG) goto L56;
        if ((r111.getProperty() instanceof RichTextElement.ImageProperty) == false) goto L56;
        RichTextElement.ImageProperty r112 = r111.getProperty();
        int r113 = DeviceUtils.getScreenWidth(r50) - UIHelper.dp2px(32.0f);
        if (r112.getOriginWidth() == 0) goto L66;
        int r114 = (r112.getOriginHeight() * r113) / r112.getOriginWidth();
    L67:
        r112.setOriginWidth(r113);
        r112.setOriginHeight(r114);
        goto L69
    L66:
        r114 = r112.getOriginHeight();
        Log.e(TitlebarViewModel.LOG_TAG, "announce image origin width == 0");
        goto L67
    L48:
        r19 = 4;
    L69:
        int r115 = r49.x;
        if (r115 != 23) goto L72;
    L75:
        boolean r116 = true;
    L76:
        if (r22 == true) goto L79;
        if (r116 == true) goto L79;
    L81:
        boolean r23 = false;
    L82:
        CodeBlockV2ProcessParams r117 = r49.z;
        if (r117 != null) goto L91;
        Intrinsics.checkNotNullParameter(r49, "params");
        Intrinsics.checkNotNullParameter(r50, "context");
        int r118 = (int) zz7.b.h(r50, 12);
        int r119 = zz7.b.g(r50, 16);
        int r120 = r49.y;
        if (r120 <= 0) goto L88;
        CodeBlockV2ProcessParams.Companion.getClass();
        r117 = CodeBlockV2ProcessParams.b.b(r120, r118, r119);
        goto L91
    L88:
        if (r51 == Integer.MAX_VALUE) goto L90;
        CodeBlockV2ProcessParams.Companion.getClass();
        r117 = CodeBlockV2ProcessParams.b.b(r51, r118, r119);
        goto L91
    L90:
        CodeBlockV2ProcessParams.Companion.getClass();
        r117 = CodeBlockV2ProcessParams.b.c(r50, r118, r119);
    L91:
        Intrinsics.checkNotNullParameter(r49, "params");
        TableProcessParams r121 = new TableProcessParams(r49.H, r51, r49.x, r49.J);
        Intrinsics.checkNotNullParameter(r49, "params");
        ColumnsProcessParams r24 = new ColumnsProcessParams(r49.I, r51, r49.x, r49.K);
        boolean r25 = r49.d;
        int r122 = r49.X;
        PrefixSpanStyle r123 = r49.Y;
        Intrinsics.checkNotNullParameter(r117, "codeBlockProcessParams");
        Intrinsics.checkNotNullParameter(r121, "tableProcessParams");
        Intrinsics.checkNotNullParameter(r24, "columnsProcessParams");
        Intrinsics.checkNotNullParameter(r123, "prefixSpanStyle");
        lec.b.a r124 = new lec.b.a();
        r124.b = true;
        r124.c = true;
        r124.i = r23;
        r124.h = r19;
        r124.j = r51;
        r124.a = !xbc.a.a().isUseAtProcessV2();
        r124.p = r117;
        r124.k = r25;
        r124.f = r121.isShowTableDetail();
        r124.q = r121.getTableCellsLayoutMap();
        r124.r = r24.getColumnsLayoutMap();
        r124.g = r24.isShowColumnsDetail();
        r124.l = r122;
        r124.m = r123;
        lec.e r0 = lec.d.a(r50, r48, new lec.b(r124));
        if (r0 != null) goto L94;
        r0 = new lec.e(BuildConfig.FLAVOR, new RecogniseSpansResult(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()));
    L94:
        boolean r26 = r49.c;
        boolean r27 = r49.m;
        Intrinsics.checkNotNullParameter(r0, ChameleonOpenTracker.ParamKey.RESULT);
        ArrayList r28 = new ArrayList();
        List r29 = r0.b.getAllSpanInfos();
        if (CollectionUtils.isNotEmpty(r29) == false) goto L97;
        r28.addAll(r29);
    L97:
        Pattern r30 = g0.d;
        g0 r31 = g0.a.a;
        String r32 = r0.a;
        r31.getClass();
        if (TextUtils.isEmpty(r32) == true) goto L105;
        if (r26 == false) goto L102;
        g0.a(r28, g0.h(r32, null, r28));
    L102:
        if (r27 == false) goto L104;
        g0.a(r28, r31.f(r32, r28));
    L104:
        Collections.sort(r28);
    L105:
        Intrinsics.checkNotNull(r28);
        boolean r33 = r49.O;
        if (r28.isEmpty() == true) goto L138;
        ArrayList r34 = new ArrayList();
        ArrayList r35 = new ArrayList();
        Iterator r36 = r28.iterator();
    L110:
        if (r36.hasNext() == false) goto L124;
        AbbreviationInfo r125 = (SpanInfo) r36.next();
        if ((r125 instanceof AbbreviationInfo) == true) goto L113;
        if ((r125 instanceof PhoneInfo) == true) goto L123;
        if ((r125 instanceof UrlInfo) == false) goto L110;
    L123:
        r34.add(r125);
        goto L110
    L113:
        AbbreviationInfo.AbbreviationType r126 = r125.bizType;
        if (r126 == AbbreviationInfo.AbbreviationType.BAIKE) goto L115;
        if (r126 != AbbreviationInfo.AbbreviationType.CALENDAR) goto L110;
        r35.add(r125);
        goto L110
    L115:
        r34.add(r125);
        goto L110
    L124:
        Iterator r37 = r35.iterator();
    L126:
        if (r37.hasNext() == false) goto L138;
        AbbreviationInfo r38 = (AbbreviationInfo) r37.next();
        if (r33 == true) goto L129;
        Iterator r127 = r34.iterator();
    L132:
        if (r127.hasNext() == false) goto L126;
        SpanInfo r128 = (SpanInfo) r127.next();
        int r129 = r128.end - 1;
        int r130 = ((SpanInfo) r38).end - 1;
        if (r129 < ((SpanInfo) r38).start) goto L132;
        if (r130 < r128.start) goto L132;
        r28.remove(r38);
        goto L132
    L129:
        r28.remove(r38);
    L138:
        boolean r39 = r49.d;
        boolean r40 = r49.h;
        List<String> r41 = r49.a;
        List<String> r42 = r49.b;
        String r131 = r49.l;
        ValidateResult r132 = r49.n;
        boolean r133 = r49.o;
        boolean r134 = r49.i;
        String r135 = r49.p;
        String r136 = r49.q;
        int r43 = r49.B.getValue();
        lec.e r137 = r0;
        ValidateIMFileResult r1 = r49.C;
        boolean r3 = r49.D;
        boolean r4 = r49.E;
        boolean r44 = r49.F;
        int r45 = r49.x;
        int r2 = r49.N;
        int r46 = r49.Q;
        int r47 = r49.R;
        c0.b r138 = r49.S;
        int r139 = r49.T;
        int r140 = r49.U;
        int r141 = r49.V;
        int r142 = r49.W;
        boolean r52 = r49.Z;
        Intrinsics.checkNotNullParameter(r41, "readAtChatterId");
        Intrinsics.checkNotNullParameter(r42, "botIds");
        Intrinsics.checkNotNullParameter(r131, "anonymousId");
        Intrinsics.checkNotNullParameter(r50, "context");
        Intrinsics.checkNotNullParameter(r132, "previewValidateResult");
        if (r45 != 18) goto L141;
    L146:
        boolean r53 = true;
    L147:
        com.ss.android.lark.widget.light.e.a r54 = new com.ss.android.lark.widget.light.e.a(r50);
        if (r39 == false) goto L151;
        if (r40 == true) goto L151;
        boolean r55 = true;
    L152:
        r54.c = r55;
        Intrinsics.checkNotNullParameter(r41, "atReadUserList");
        CollectionUtils.resetToList(r54.a, r41);
        Intrinsics.checkNotNullParameter(r42, "botIdList");
        CollectionUtils.resetToList(r54.b, r42);
        if (r139 > 0) goto L156;
        r139 = zz7.b.g(r50, 20);
    L156:
        r54.j = r139;
        r54.k = r140;
        r54.l = r141;
        r54.m = r142;
        int r56 = p3b.a.W;
        if (r39 == false) goto L159;
        int r57 = v4b.a.k;
    L160:
        r54.s = UIUtils.getColor(r50, r57);
        if (r39 == false) goto L163;
        int r58 = v4b.a.l;
    L164:
        r54.w = UIUtils.getColor(r50, r58);
        if (r39 == false) goto L167;
        int r59 = v4b.a.m;
    L168:
        r54.x = UIUtils.getColor(r50, r59);
        if (r46 > 0) goto L172;
        r46 = (int) zz7.b.h(r50, 17);
    L172:
        r54.g = r46;
        r54.h = r47;
        if (r138 != null) goto L175;
        c0.b r143 = new c0.b(-1, -1);
    L176:
        r54.i = r143;
        r54.a(ChatCoreModule.a().getLoginDependency().getUserId());
        Intrinsics.checkNotNullParameter(r131, "anonymousUserId");
        r54.e = r131;
        Intrinsics.checkNotNullParameter(r132, "previewValidateResult");
        r54.o = r132;
        r54.p = r133;
        r54.q = r134;
        r54.C = r135;
        r54.D = r136;
        r54.E = r43;
        r54.F = r1;
        r54.G = r3;
        r54.H = r4;
        r54.I = r44;
        r54.J = r51;
        r54.K = false;
        r54.L = r45;
        r54.M = r2;
        r54.B = r53;
        r54.O = !r52;
        CharSequence r60 = com.ss.android.lark.widget.light.f.a.a.b(r50, r137.a, r28, new com.ss.android.lark.widget.light.e(r54));
        Intrinsics.checkNotNull(r60);
        Intrinsics.checkNotNullParameter(r50, "context");
        Intrinsics.checkNotNullParameter(r60, "spannable");
        Intrinsics.checkNotNullParameter(r49, "params");
        CharSequence r61 = r60;
        if (r49.w == true) goto L180;
    L184:
        Intrinsics.checkNotNullParameter(r50, "context");
        Intrinsics.checkNotNullParameter(r61, "spannable");
        Intrinsics.checkNotNullParameter(r49, "params");
        CharSequence r62 = r61;
        if (r49.r == false) goto L202;
        r62 = r61;
        if (r49.s == true) goto L202;
        if ((r61 instanceof SpannableStringBuilder) == false) goto L192;
        SpannableStringBuilder r63 = (SpannableStringBuilder) r61;
    L193:
        f.a(r63, r50);
        int r64 = r49.u;
        if (r64 != (-1)) goto L196;
        int r144 = 12;
    L197:
        float r65 = zz7.b.g(r50, r144);
        String r66 = r50.getString(2131891078);
        SpannableStringBuilder r67 = new SpannableStringBuilder(r66);
        Integer r68 = r49.t;
        if (r68 == null) goto L200;
        int r69 = r68.intValue();
    L201:
        r67.setSpan(new e(r66, UIUtils.getColor(r50, r69), r65), 0, r66.length(), 33);
        r67.setSpan(new p(r67, r66), 0, r66.length(), 33);
        r63.append(r67);
        r62 = r63;
        goto L202
    L200:
        r69 = 2131106607;
        goto L201
    L196:
        r144 = r64;
        goto L197
    L192:
        r63 = new SpannableStringBuilder(r61);
    L202:
        return r62;
    L180:
        if ((r60 instanceof SpannableStringBuilder) == false) goto L182;
        SpannableStringBuilder r70 = (SpannableStringBuilder) r60;
    L183:
        f.a(r70, r50);
        d0 r71 = new d0();
        int r72 = r70.length();
        r70.append("|");
        r70.setSpan(r71, r72, r70.length(), 17);
        r61 = r70;
        goto L184
    L182:
        r70 = new SpannableStringBuilder(r60);
        goto L183
    L175:
        r143 = r138;
        goto L176
    L167:
        r59 = v4b.a.L;
        goto L168
    L163:
        r58 = v4b.a.K;
        goto L164
    L159:
        r57 = v4b.a.J;
    L151:
        r55 = false;
        goto L152
    L141:
        if (r45 == 20) goto L146;
        if (r45 == 21) goto L146;
        r53 = false;
    L79:
        if (r49.i == true) goto L81;
        r23 = true;
        goto L82
    L72:
        if (r115 == 22) goto L75;
        r116 = false;
    L43:
        r22 = true;
        goto L45
    L33:
        if (CollectionUtils.isNotEmpty(r48.getMediaIds()) == true) goto L36;
        r20 = false;
        goto L37
    L29:
        r19 = 0;
        goto L31
    }
}
