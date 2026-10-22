package sb2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.e5;
import com.bytedance.android.live.base.model.message.g5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.e8;
import com.bytedance.android.livesdk.interactivity.service.textrender.inject.IGiftImageGetter;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import gm2.q;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import om0.c;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final Spannable a = null;
    public static final yb2.a b = null;

    static {
        a = new SpannableString(BuildConfig.FLAVOR);
        yb2.a r0 = new yb2.a();
        r0.b = s1.h(2131108439);
        r0.a = s1.h(2131108438);
        r0.c = s1.h(2131108437);
        r0.e = s1.h(2131108438);
        r0.g = BuildConfig.FLAVOR;
        r0.j = false;
        b = r0;
    }

    public static yb2.a c() {
        if (((Boolean) e8.a.getValue()).booleanValue() == true) goto L5;
        yb2.a r0 = new yb2.a();
        r0.b = s1.h(2131108439);
        r0.a = s1.h(2131108438);
        r0.c = s1.h(2131108437);
        r0.e = s1.h(2131108438);
        r0.g = BuildConfig.FLAVOR;
        r0.j = false;
        return r0;
    L5:
        return b;
    }

    public static List<k> d(a5 r3) {
        ArrayList r0 = new ArrayList();
        if (r3 != null) goto L5;
    L20:
        return r0;
    L5:
        if (r3.getPieces() == null) goto L20;
        if (r3.getPieces().isEmpty() == true) goto L20;
        Iterator r4 = r3.getPieces().iterator();
    L10:
        if (r4.hasNext() == false) goto L20;
        c5 r1 = (c5) r4.next();
        if (r1 == null) goto L10;
        if (r1.getImageValue() == null) goto L10;
        if (r1.getImageValue().getImageModel() == null) goto L10;
        if (Lists.isEmpty(r1.getImageValue().getImageModel().getUrls()) == true) goto L10;
        r0.add(r1.getImageValue().getImageModel());
        goto L10
    }

    public static boolean e(ITextPieceImage r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.getImageModel() != null) goto L7;
        return false;
    L7:
        return !TextUtils.isEmpty(jc1.k.f(IHostFrescoHelper.class).getImageFilePath(r1.getImageModel()));
    }

    public static tb2.a f(a5 r2, yb2.a r3) {
        String r0 = BuildConfig.FLAVOR;
        if (r2 == null) goto L9;
        if (TextUtils.isEmpty(BuildConfig.FLAVOR) == false) goto L9;
        r0 = r2.getDefaultPattern();
    L9:
        return g(r0, r2, r3);
    }

    public static Spannable i(String r1, a5 r2) {
        return g(r1, r2, c()).a;
    }

    public static tb2.a g(String r4, a5 r5, yb2.a r6) {
        tb2.a r0 = new tb2.a();
        r0.a = a;
        if (TextUtils.isEmpty(r4) == true) goto L25;
        if (r5 == null) goto L25;
        if (r5.getPieces() != null) goto L9;
    L24:
        SpannableString r1 = new SpannableString(r4);
        r1.setSpan(new ForegroundColorSpan(b(PieceType.STRING.getPieceType(), null, r5.getDefaultFormat(), r6)), 0, r1.length(), 18);
        r0.a = r1;
        goto L25
    L9:
        if (r5.getPieces().size() == 0) goto L24;
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L18
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Exception -> L18
        j(r4, r5.getPieces(), r2, r3, r6);     // Catch: Exception -> L18
        if (r2.size() > 0) goto L14;
    L17:
        return r0;
    L14:
        if (r2.size() != r3.size()) goto L17;
        return a(r2, r3, r5.getDefaultFormat(), r6);
    L18:
        e = move-exception;
        if (c.c() == null) goto L22;
        c.c().stacktrace(6, "ttlive_exception", e.getStackTrace());
    L22:
        StringWriter r7 = new StringWriter();
        e.printStackTrace(new PrintWriter(r7));
        HashMap r8 = new HashMap();
        r8.put("stack_trace", r7.toString());
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixError("ttlive_parse_text_status"), 1, r8);
        return r0;
    L25:
        return r0;
    }

    public static Spannable h(a5 r2, String r3, boolean r4) {
        if (r2 == null) goto L4;
    L7:
        if (r2 == null) goto L9;
        if (r4 == false) goto L12;
        yb2.a r5 = b;
    L13:
        String r0 = BuildConfig.FLAVOR;
        if (TextUtils.isEmpty(BuildConfig.FLAVOR) == false) goto L16;
        r0 = r2.getDefaultPattern();
    L16:
        Spannable r6 = g(r0, r2, r5).a;
        Spannable r7 = a;
        if (r6 == r7) goto L20;
        return r6;
    L20:
        if (TextUtils.isEmpty(r3) == false) goto L23;
        return r7;
    L23:
        return new SpannableString(r3);
    L12:
        r5 = c();
        goto L13
    L9:
        return new SpannableString(r3);
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return a;
    }

    public static tb2.a a(List<String> r17, Map<Integer, c5> r18, b5 r19, yb2.a r20) {
        tb2.a r3 = new tb2.a();
        r3.a = a;
        if (CollectionUtils.isEmpty(r17) == false) goto L5;
    L97:
        return r3;
    L5:
        if (r18.isEmpty() == true) goto L97;
        ArrayList r4 = (ArrayList) r17;
        if (r4.size() != r18.size()) goto L10;
        StringBuilder r6 = new StringBuilder();
        Iterator r7 = r4.iterator();
    L15:
        if (r7.hasNext() == false) goto L17;
        r6.append((String) r7.next());
        goto L15
    L17:
        SpannableString r5 = new SpannableString(r6.toString());
        r5.setSpan(new ForegroundColorSpan(b(PieceType.STRING.getPieceType(), null, r19, r20)), 0, r5.length(), 18);
        int r8 = 0;
        int r9 = 0;
    L19:
        if (r8 >= r4.size()) goto L96;
        String r10 = (String) ListProtector.get(r17, r8);
        if (r10 != null) goto L23;
        r10 = BuildConfig.FLAVOR;
    L23:
        c5 r11 = (c5) ((LinkedHashMap) r18).get(Integer.valueOf(r8));
        if (r11 != null) goto L26;
    L94:
        int r13 = r10.length();
    L95:
        r9 = r9 + r13;
        r8 = r8 + 1;
        goto L19
    L26:
        if (r11.isNormalPiece() == true) goto L94;
        int r14 = b(r11.getType(), r11.getFormat(), r19, r20);
        if (r11.getType() != PieceType.STRING.getPieceType()) goto L31;
    L78:
        r5.setSpan(new ForegroundColorSpan(r14), r9, r10.length() + r9, 17);
    L80:
        if (r11.getFormat() == null) goto L89;
        int r15 = r11.getFormat().getWeight();
        if (r15 < 700) goto L85;
        r5.setSpan(new StyleSpan(1), r9, r10.length() + r9, 33);
        goto L89
    L85:
        if (r15 <= 0) goto L89;
        r5.setSpan(new StyleSpan(0), r9, r10.length() + r9, 33);
    L89:
        if (r11.getFormat() == null) goto L93;
        int r16 = r11.getFormat().getFontSize();
        if (r16 <= 0) goto L93;
        r5.setSpan(new AbsoluteSizeSpan(r16, true), r9, r10.length() + r9, 33);
    L93:
        r13 = r10.length();
        goto L95
    L31:
        if (r11.getType() == PieceType.PATTERN_REF.getPieceType()) goto L78;
        if (r11.getType() != PieceType.USER.getPieceType()) goto L39;
        if (r11.getUserValue() == null) goto L39;
        r11.getUserValue();
        r5.setSpan(new ForegroundColorSpan(r14), r9, r10.length() + r9, 17);
    L39:
        if (r11.getType() != PieceType.GIFT.getPieceType()) goto L46;
        if (r11.getGiftValue() == null) goto L46;
        k r110 = ((IGiftImageGetter) jc1.k.f(IGiftImageGetter.class)).getGiftImage(r11.getGiftValue().getGiftId());
        if (r110 == null) goto L80;
        ((ArrayList) r3.b).add(new tb2.a.C0284a(r110));
    L46:
        if (r11.getType() != PieceType.IMAGE.getPieceType()) goto L80;
        if (r11.getImageValue() == null) goto L80;
        if (r11.getImageValue().getImageModel() == null) goto L80;
        if (Lists.isEmpty(r11.getImageValue().getImageModel().getUrls()) == true) goto L80;
        ITextPieceImage r111 = r11.getImageValue();
        int r112 = r9 + 1;
        if (e(r111) == false) goto L80;
        Bitmap r113 = BitmapFactory.decodeFile(jc1.k.f(IHostFrescoHelper.class).getImageFilePath(r111.getImageModel()));
        k r114 = r111.getImageModel();
        if (r113 == null) goto L80;
        if (r113.isRecycled() == true) goto L80;
        if (r5.length() == 0) goto L80;
        if (r9 < 0) goto L80;
        if (r9 > r5.length()) goto L80;
        if (r9 > r112) goto L80;
        if (r114 == null) goto L80;
        Context r115 = s1.getContext();
        if (r114.getWidth() != 0) goto L70;
    L73:
        int r116 = s1.f(20.0f);
        if (r113.getHeight() <= r116) goto L76;
        int r117 = (int) ((r116 / r113.getHeight()) * r113.getWidth());
    L77:
        BitmapDrawable r21 = new BitmapDrawable(r115.getResources(), r113);
        r21.setBounds(0, 0, r117, r116);
        r5.setSpan(new com.bytedance.android.livesdk.widget.a(r21), r9, r112, 33);
        goto L80
    L76:
        r116 = r113.getHeight();
        r117 = r113.getWidth();
        goto L77
    L70:
        if (r114.getHeight() == 0) goto L73;
        r117 = s1.f(r114.getWidth());
        r116 = s1.f(r114.getHeight());
        goto L77
    L96:
        r3.a = r5;
        goto L97
    L10:
        if (c.c() == null) goto L12;
        c.c().e("I18N_MESSAGE", "parse error! mTarget.size() != mTextPieceMap.size()");
    L12:
        return r3;
    }

    public static int b(int r6, b5 r7, b5 r8, yb2.a r9) {
        if (r9 != null) goto L4;
        r9 = new yb2.a();
    L4:
        boolean r0 = true;
        int r1 = 0;
        if (r7 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        PieceType r3 = PieceType.STRING;
        if (r6 != r3.getPieceType()) goto L16;
        if (r7 == null) goto L16;
        if (r7.isUseHeighLight() == false) goto L16;
    L18:
        if (r7 != null) goto L20;
    L19:
        int r10 = 0;
    L27:
        int r5 = r9.e;
        if (r6 != r3.getPieceType()) goto L31;
        int r11 = r9.d;
    L40:
        if (r8 == null) goto L49;
        String r13 = r8.getColor();
        if (TextUtils.isEmpty(r13) == true) goto L49;
        r1 = Color.parseColor(r13);     // Catch: Exception -> L47
    L47:
        e = move-exception;
        Logger.e("I18N_MESSAGE", e.getMessage());
    L49:
        if (r2 == false) goto L52;
        if (r10 == 0) goto L52;
        return r10;
    L52:
        if (r0 == false) goto L55;
        if (r5 == 0) goto L55;
        return r5;
    L55:
        if (r11 == 0) goto L60;
        if (r8 == null) goto L60;
        if (r8.isUseRemoteColor() == true) goto L60;
        return r11;
    L60:
        if (r1 == 0) goto L62;
        return r1;
    L62:
        return -1;
    L31:
        if (r6 != PieceType.USER.getPieceType()) goto L34;
        r11 = r9.a;
        goto L40
    L34:
        if (r6 != PieceType.GIFT.getPieceType()) goto L37;
        r11 = r9.b;
        goto L40
    L37:
        if (r6 != PieceType.PATTERN_REF.getPieceType()) goto L39;
        r11 = r9.c;
        goto L40
    L39:
        r11 = r9.d;
        goto L40
    L20:
        String r14 = r7.getColor();
        if (TextUtils.isEmpty(r14) == true) goto L19;
        r10 = Color.parseColor(r14);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        Logger.e("I18N_MESSAGE", e.getMessage());
    L16:
        r0 = false;
        goto L18
    L7:
        if (r7.isUseRemoteColor() == false) goto L9;
        r2 = true;
        goto L10
    }

    public static void j(String r18, List<? extends c5> r19, List<String> r20, Map<Integer, c5> r21, yb2.a r23) {
        if (r18 == null) goto L157;
        if (r19 != null) goto L6;
        return;
    L6:
        if (r19.size() == 0) goto L160;
        ArrayList r5 = new ArrayList();
        r5.add(r20);
        r5.add(r21);
        StringBuilder r6 = new StringBuilder();
        int r7 = 0;
        int r8 = -1;
        int r9 = 0;
        int r10 = 0;
        int r11 = -1;
        int r13 = -1;
        int r14 = -1;
    L10:
        if (r9 >= r18.length()) goto L147;
        char r15 = r18.charAt(r9);
        if (r15 != ':') goto L14;
        if (r10 == 0) goto L145;
        if (r10 != 1) goto L141;
        r14 = CastIntegerProtector.valueOf(r18.subSequence(r11, r9).toString()).intValue();
        r13 = r9 + 1;
        char r16 = '}';
        r11 = -1;
    L143:
        if (r15 == r16) goto L145;
        r6.append(r15);
        goto L145
    L141:
        return;
    L145:
        r9 = r9 + 1;
        r7 = 0;
        r8 = -1;
        goto L10
    L14:
        if (r15 == '{') goto L128;
        if (r15 != '}') goto L136;
        if (r13 == r8) goto L19;
        String r17 = r18.subSequence(r13, r9).toString();
    L20:
        if (r14 == r8) goto L127;
        if (r6.length() <= 0) goto L24;
        r6.delete(r7, r6.length());
    L24:
        String r110 = null;
        if (r14 >= 0) goto L27;
    L56:
        c5 r24 = null;
    L57:
        if (r24 == null) goto L125;
        int r25 = r24.getType();
        if (r25 != PieceType.STRING.getPieceType()) goto L62;
        r110 = r24.getStringValue();
    L61:
        String r111 = r110;
    L124:
        ArrayList r26 = (ArrayList) r20;
        r26.add(r111);
        r21.put(Integer.valueOf(r26.size() - 1), r24);
    L126:
        r10 = r10 - 1;
        r16 = '}';
        r13 = -1;
        r14 = -1;
        goto L143
    L62:
        int r112 = PieceType.USER.getPieceType();
        r111 = BuildConfig.FLAVOR;
        if (r25 != r112) goto L91;
        i5 r27 = r24.getUserValue();
        if (r27 == null) goto L61;
        if (r27.getUser() == null) goto L61;
        if (r27.isWithColon() == false) goto L73;
        r111 = "：";
    L73:
        if (TextUtils.isEmpty(r23.g) == false) goto L75;
    L79:
        boolean r113 = false;
    L81:
        if (r23.j == false) goto L85;
        if (r113 == false) goto L85;
        String r28 = s1.B(2131915891) + r111;
    L107:
        r110 = r28;
    L85:
        if (r23.k == true) goto L87;
    L89:
        r28 = q.b(r27.getUser()).concat(r111);
        goto L107
    L87:
        if (TextUtils.isEmpty(r27.getUser().getSafeNicName()) == true) goto L89;
        r28 = r27.getUser().getSafeNicName() + r111;
        goto L107
    L75:
        if ("0".equals(r23.g) == true) goto L79;
        if (TextUtils.equals(String.valueOf(r23.g), r27.getUser().getIdString()) == false) goto L79;
        r113 = true;
        goto L81
    L91:
        if (r25 != PieceType.GIFT.getPieceType()) goto L109;
        e5 r29 = r24.getGiftValue();
        if (r29 == null) goto L61;
        if (r29.getNameRef() != null) goto L98;
    L106:
        r28 = s1.B(2131919136) + " . ";
        goto L107
    L98:
        if (r29.getNameRef().getKey() == null) goto L106;
        if (TextUtils.isEmpty(BuildConfig.FLAVOR) == false) goto L103;
        r111 = r29.getNameRef().getDefaultPattern();
    L103:
        if (TextUtils.isEmpty(r111) == false) goto L105;
        r111 = s1.B(2131919136);
    L105:
        r28 = r111 + " . ";
        goto L107
    L109:
        if (r24.getType() != PieceType.HEART.getPieceType()) goto L112;
    L123:
        r110 = " ";
        goto L61
    L112:
        if (r25 != PieceType.PATTERN_REF.getPieceType()) goto L120;
        g5 r30 = r24.getPatternRefValue();
        if (r30 == null) goto L124;
        if (TextUtils.isEmpty(r30.getDefaultPattern()) == true) goto L124;
        r28 = r30.getDefaultPattern();
        goto L107
    L120:
        if (r25 != PieceType.IMAGE.getPieceType()) goto L61;
        if (e(r24.getImageValue()) == false) goto L124;
    L125:
        Logger.e("I18N_MESSAGE", "piece result is null !!! \npattern:" + r18 + "... index:" + r14 + "...tag:" + r17);
        goto L126
    L27:
        if (r14 >= r19.size()) goto L56;
        if (TextUtils.isEmpty(r17) == true) goto L56;
        if (r19.size() == 0) goto L56;
        r24 = (c5) ListProtector.get(r19, r14);
        int r114 = r24.getType();
        PieceType r115 = PieceType.HEART;
        if (r114 == r115.getPieceType()) goto L53;
        r115 = PieceType.USER;
        if (r114 == r115.getPieceType()) goto L53;
        r115 = PieceType.STRING;
        if (r114 == r115.getPieceType()) goto L53;
        r115 = PieceType.GIFT;
        if (r114 == r115.getPieceType()) goto L53;
        r115 = PieceType.PATTERN_REF;
        if (r114 == r115.getPieceType()) goto L53;
        r115 = PieceType.IMAGE;
        if (r114 == r115.getPieceType()) goto L53;
        r115 = PieceType.UNKNOWN;
    L53:
        if (r115.getTag().equals(r17) == true) goto L57;
        Logger.e("I18N_MESSAGE", "TextPieceHelper: tag is false");
        goto L56
    L127:
        return;
    L19:
        r14 = CastIntegerProtector.valueOf(r18.subSequence(r11, r9).toString()).intValue();
        r17 = "string";
    L136:
        r16 = '}';
        goto L143
    L128:
        r10 = r10 + 1;
        if (r10 != 1) goto L130;
        r11 = r9 + 1;
        if (r6.length() <= 0) goto L136;
        if (r6.length() <= 0) goto L136;
        ArrayList r31 = (ArrayList) r20;
        r31.add(r6.toString());
        c5 r33 = (c5) f.c(c5.class);
        r33.setNormalPiece(true);
        r21.put(Integer.valueOf(r31.size() - 1), r33);
        r6.delete(0, r6.length());
        goto L136
    L130:
        return;
    L147:
        if (r6.length() <= 0) goto L159;
        ArrayList r1 = (ArrayList) r20;
        r1.add(r6.toString());
        c5 r0 = (c5) f.c(c5.class);
        r0.setNormalPiece(true);
        r21.put(Integer.valueOf(r1.size() - 1), r0);
        r6.delete(0, r6.length());
        return;
    L159:
        return;
    L160:
        return;
    }
}
