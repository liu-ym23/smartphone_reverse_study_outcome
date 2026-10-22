package zs0;

import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.ProfileImageFormat;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.base.model.user.ProfileTextFormat;
import com.bytedance.android.live.base.model.user.ProfileTextPiece;
import com.bytedance.android.live.base.model.user.ProfileTextPieceImage;
import com.bytedance.android.live.base.model.user.ProfileTextPieceString;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.ui.component.u;
import com.bytedance.android.live.profile.ui.util.m;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import py.k;
import rs0.d0;
import rs0.l0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final a a = null;

    public c() {
    }

    static {
        a = new a();
    }

    public static void a(LinearLayout r24, ProfileText r25, u r26, b r27) {
        if (r24 != null) goto L5;
        return;
    L5:
        if (r25 != null) goto L7;
        return;
    L7:
        List r0 = r25.getPieces();
        if (r0 == null) goto L155;
        Iterator r4 = r0.iterator();
    L11:
        if (r4.hasNext() == false) goto L172;
        ProfileTextPiece r5 = (ProfileTextPiece) r4.next();
        if (r5 == null) goto L11;
        int r1 = r5.getType();
        int r8 = 80;
        boolean r10 = false;
        Float r12 = null;
        if (r1 == ProfileTextPiece.PIECE_TYPE_STRING) goto L17;
        if (r1 != ProfileTextPiece.PIECE_TYPE_IMAGE) goto L11;
        ProfileTextPieceImage r2 = r5.getImageValue();
        if (r2 == null) goto L11;
        k r6 = r2.getImageModel();
        if (r6 == null) goto L11;
        HSImageView r7 = new HSImageView(r24.getContext());
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.i(r6.getWidth()), UtilityKotlinExtentionsKt.i(r6.getHeight()));
        int r14 = r5.getAlignment();
        if (r14 != ProfileTextPiece.ALIGNMENT_TOP) goto L93;
        r8 = 48;
    L95:
        r3.gravity = r8;
        Unit r9 = Unit.INSTANCE;
        r24.addView(r7, r3);
        k.b r13 = r6.getImageContent();
        if (r13 == null) goto L98;
        String r15 = r13.getFontColor();
    L99:
        if (r15 != null) goto L101;
    L104:
        boolean r16 = true;
    L105:
        if (r16 == false) goto L156;
    L114:
        ProfileTextPieceImage r17 = r5.getImageValue();
        if (r17 == null) goto L117;
        ProfileImageFormat r18 = r17.getImageFormat();
    L118:
        if (r18 == null) goto L150;
        if (((Boolean) l0.a.getValue()).booleanValue() == true) goto L123;
        Float r19 = Float.valueOf(r18.getImageRadius());
        if (r19.floatValue() <= 0) goto L143;
        r10 = true;
    L143:
        if (r10 == false) goto L145;
        r12 = r19;
    L145:
        if (r12 == null) goto L150;
        float r20 = r12.floatValue();
        GenericDraweeHierarchy r22 = r7.getHierarchy();
        if (r22 == null) goto L150;
        r22.setRoundingParams(RoundingParams.fromCornersRadius(r20));
        goto L150
    L123:
        if (r18.isImageCircle() == false) goto L125;
        RoundingParams r23 = RoundingParams.asCircle();
    L126:
        Float r28 = Float.valueOf(r18.getImageRadius());
        if (r28.floatValue() <= 0) goto L129;
        r10 = true;
    L129:
        if (r10 == false) goto L131;
        r12 = r28;
    L131:
        if (r12 == null) goto L136;
        float r29 = r12.floatValue();
        if (r23 != null) goto L135;
        r23 = new RoundingParams();
    L135:
        r23.setCornersRadius(r29);
    L136:
        if (r23 == null) goto L150;
        GenericDraweeHierarchy r30 = r7.getHierarchy();
        if (r30 == null) goto L150;
        r30.setRoundingParams(r23);
        goto L150
    L125:
        r23 = null;
    L150:
        if (((Boolean) d0.a.getValue()).booleanValue() == false) goto L152;
        ImageLoader.bindImageWithAnimation(r7, r6, r26, true, true);
    L153:
        if (r27 == null) goto L11;
        r27.b(r7, r25, r5);
        goto L11
    L152:
        ImageUtil.loadImage(r7, r6, -1, -1, true, 0, true, r26);
        goto L153
    L117:
        r18 = null;
        goto L118
    L156:
        k.b r32 = r6.getImageContent();     // Catch: Exception -> L112
        if (r32 == null) goto L109;
        String r33 = r32.getFontColor();     // Catch: Exception -> L112
    L110:
        r7.setColorFilter(Color.parseColor(r33));     // Catch: Exception -> L112
        goto L114
    L109:
        r33 = null;
    L112:
        e = move-exception;
        ALogger.e("ProfileTextParser", "parse image color error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L114
    L101:
        if (r15.length() == 0) goto L104;
        r16 = false;
        goto L105
    L98:
        r15 = null;
        goto L99
    L93:
        if (r14 != ProfileTextPiece.ALIGNMENT_CENTER) goto L95;
        r8 = 16;
        goto L95
    L17:
        ProfileTextPieceString r34 = r5.getStringValue();
        if (r34 == null) goto L11;
        if (r34.getValue() == null) goto L11;
        ProfileTextPieceString r35 = r5.getStringValue();
        if (r35 == null) goto L25;
        ProfileTextFormat r36 = r35.getFormat();
    L26:
        TextView r37 = new TextView(r24.getContext());
        ProfileTextPieceString r110 = r5.getStringValue();
        if (r110 == null) goto L29;
        String r111 = r110.getValue();
    L30:
        r37.setText(r111);
        if (r36 == null) goto L33;
        int r112 = r36.getFontSize();
    L34:
        r37.setTextSize(1, r112);
        if (r36 == null) goto L37;
        int r113 = r36.getFontType();
    L38:
        if (r36 == null) goto L40;
        int r114 = r36.getFontStyle();
    L42:
        if (r113 == ProfileTextFormat.FONT_TYPE_NORMAL) goto L52;
        if (r113 == ProfileTextFormat.FONT_TYPE_DEFAULT) goto L52;
        if (r113 == ProfileTextFormat.FONT_TYPE_COMPATIBLE_NORMAL) goto L52;
        if (r113 != ProfileTextFormat.FONT_TYPE_CLARITY_MONO_BOLD) goto L56;
        m.a(r37);
    L56:
        if (r36 == null) goto L58;
        String r38 = r36.getFontColor();
    L59:
        if (r38 != null) goto L61;
    L62:
        r10 = true;
    L63:
        if (r10 == true) goto L72;
        if (r36 != null) goto L158;
        String r39 = null;
    L69:
        r37.setTextColor(Color.parseColor(r39));     // Catch: Exception -> L66
        goto L72
    L158:
        r39 = r36.getFontColor();     // Catch: Exception -> L66
    L66:
        e = move-exception;
        ALogger.e("ProfileTextParser", "parse string color error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
    L72:
        LinearLayout.LayoutParams r40 = new LinearLayout.LayoutParams(-2, -2);
        int r42 = r5.getAlignment();
        if (r42 != ProfileTextPiece.ALIGNMENT_TOP) goto L76;
        int r43 = 48;
    L79:
        r40.gravity = r43;
        Unit r44 = Unit.INSTANCE;
        r24.addView(r37, r40);
        if (r27 == null) goto L11;
        r27.a(r37, r25, r5);
        goto L11
    L76:
        if (r42 != ProfileTextPiece.ALIGNMENT_CENTER) goto L78;
        r43 = 16;
        goto L79
    L78:
        r43 = 80;
        goto L79
    L61:
        if (r38.length() != 0) goto L63;
    L58:
        r38 = null;
    L52:
        if (r114 != ProfileTextFormat.FONT_STYLE_BOLD) goto L54;
        Typeface r45 = Typeface.defaultFromStyle(1);
    L55:
        r37.setTypeface(r45);
        goto L56
    L54:
        r45 = Typeface.defaultFromStyle(0);
        goto L55
    L40:
        r114 = ProfileTextFormat.FONT_STYLE_NORMAL;
        goto L42
    L37:
        r113 = ProfileTextFormat.FONT_TYPE_DEFAULT;
        goto L38
    L33:
        r112 = 0;
        goto L34
    L29:
        r111 = null;
        goto L30
    L25:
        r36 = null;
        goto L26
    L172:
        return;
    }
}
