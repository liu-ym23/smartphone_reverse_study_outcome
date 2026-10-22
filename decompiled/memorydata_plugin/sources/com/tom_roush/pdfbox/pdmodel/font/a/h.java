package com.tom_roush.pdfbox.pdmodel.font.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.crash.NpthBus;
import com.bytedance.crash.constants.Constants;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.loc.o;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.cae.userAware.WifiScanSceneType;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes6.dex */
public class h extends c {
    public static final h c = null;
    private static final Object[][] d = null;

    static {
        d = new Object[][]{new Object[]{65, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS}, new Object[]{225, "AE"}, new Object[]{66, "B"}, new Object[]{67, "C"}, new Object[]{68, com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b}, new Object[]{69, ExifInterface.LONGITUDE_EAST}, new Object[]{70, "F"}, new Object[]{71, NpthBus.UUID_SUFIX_3_1_3}, new Object[]{72, com.tom_roush.pdfbox.pdmodel.a.d.i.n}, new Object[]{73, "I"}, new Object[]{74, "J"}, new Object[]{75, "K"}, new Object[]{76, com.tom_roush.pdfbox.pdmodel.a.d.i.u}, new Object[]{232, "Lslash"}, new Object[]{77, "M"}, new Object[]{78, "N"}, new Object[]{79, "O"}, new Object[]{234, "OE"}, new Object[]{233, "Oslash"}, new Object[]{80, com.tom_roush.pdfbox.pdmodel.a.d.i.m}, new Object[]{81, "Q"}, new Object[]{82, "R"}, new Object[]{83, "S"}, new Object[]{84, ExifInterface.GPS_DIRECTION_TRUE}, new Object[]{85, "U"}, new Object[]{86, ExifInterface.GPS_MEASUREMENT_INTERRUPTED}, new Object[]{87, ExifInterface.LONGITUDE_WEST}, new Object[]{88, "X"}, new Object[]{89, "Y"}, new Object[]{90, "Z"}, new Object[]{97, "a"}, new Object[]{194, "acute"}, new Object[]{241, "ae"}, new Object[]{38, "ampersand"}, new Object[]{94, "asciicircum"}, new Object[]{Integer.valueOf(WebSocketProtocol.PAYLOAD_SHORT), "asciitilde"}, new Object[]{42, "asterisk"}, new Object[]{64, "at"}, new Object[]{98, "b"}, new Object[]{92, "backslash"}, new Object[]{124, "bar"}, new Object[]{123, "braceleft"}, new Object[]{125, "braceright"}, new Object[]{91, "bracketleft"}, new Object[]{93, "bracketright"}, new Object[]{198, "breve"}, new Object[]{183, "bullet"}, new Object[]{99, "c"}, new Object[]{Integer.valueOf(Constants.UPLOAD_HTTP_ERROR), "caron"}, new Object[]{203, "cedilla"}, new Object[]{162, "cent"}, new Object[]{195, "circumflex"}, new Object[]{58, "colon"}, new Object[]{44, "comma"}, new Object[]{168, "currency"}, new Object[]{100, "d"}, new Object[]{178, "dagger"}, new Object[]{179, "daggerdbl"}, new Object[]{200, "dieresis"}, new Object[]{36, "dollar"}, new Object[]{Integer.valueOf(WifiScanSceneType.HAR_END), "dotaccent"}, new Object[]{245, "dotlessi"}, new Object[]{101, "e"}, new Object[]{56, "eight"}, new Object[]{188, "ellipsis"}, new Object[]{208, "emdash"}, new Object[]{177, "endash"}, new Object[]{61, "equal"}, new Object[]{33, "exclam"}, new Object[]{161, "exclamdown"}, new Object[]{102, com.bytedance.apm.util.f.f1488a}, new Object[]{174, "fi"}, new Object[]{53, "five"}, new Object[]{175, "fl"}, new Object[]{166, "florin"}, new Object[]{52, "four"}, new Object[]{164, "fraction"}, new Object[]{103, o.f}, new Object[]{251, "germandbls"}, new Object[]{193, "grave"}, new Object[]{62, "greater"}, new Object[]{171, "guillemotleft"}, new Object[]{187, "guillemotright"}, new Object[]{172, "guilsinglleft"}, new Object[]{173, "guilsinglright"}, new Object[]{104, o.g}, new Object[]{205, "hungarumlaut"}, new Object[]{45, "hyphen"}, new Object[]{105, "i"}, new Object[]{106, o.j}, new Object[]{107, "k"}, new Object[]{108, "l"}, new Object[]{60, "less"}, new Object[]{248, "lslash"}, new Object[]{109, "m"}, new Object[]{197, "macron"}, new Object[]{110, "n"}, new Object[]{57, "nine"}, new Object[]{35, "numbersign"}, new Object[]{111, "o"}, new Object[]{Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION), "oe"}, new Object[]{206, "ogonek"}, new Object[]{49, "one"}, new Object[]{227, "ordfeminine"}, new Object[]{235, "ordmasculine"}, new Object[]{249, "oslash"}, new Object[]{112, "p"}, new Object[]{182, "paragraph"}, new Object[]{40, "parenleft"}, new Object[]{41, "parenright"}, new Object[]{37, "percent"}, new Object[]{46, TypedValues.CycleType.S_WAVE_PERIOD}, new Object[]{Integer.valueOf(SubsamplingScaleImageView.ORIENTATION_180), "periodcentered"}, new Object[]{189, "perthousand"}, new Object[]{43, "plus"}, new Object[]{113, "q"}, new Object[]{63, "question"}, new Object[]{191, "questiondown"}, new Object[]{34, "quotedbl"}, new Object[]{185, "quotedblbase"}, new Object[]{170, "quotedblleft"}, new Object[]{186, "quotedblright"}, new Object[]{96, "quoteleft"}, new Object[]{39, "quoteright"}, new Object[]{184, "quotesinglbase"}, new Object[]{169, "quotesingle"}, new Object[]{114, "r"}, new Object[]{202, "ring"}, new Object[]{115, "s"}, new Object[]{167, "section"}, new Object[]{59, "semicolon"}, new Object[]{55, "seven"}, new Object[]{54, "six"}, new Object[]{47, "slash"}, new Object[]{32, "space"}, new Object[]{163, "sterling"}, new Object[]{116, "t"}, new Object[]{51, "three"}, new Object[]{196, "tilde"}, new Object[]{50, "two"}, new Object[]{117, "u"}, new Object[]{95, "underscore"}, new Object[]{118, BaseSwitches.V}, new Object[]{Integer.valueOf(IdlErrors.E_RejectInferDeviceOverheat), "w"}, new Object[]{120, "x"}, new Object[]{121, "y"}, new Object[]{165, "yen"}, new Object[]{122, "z"}, new Object[]{48, "zero"}};
        c = new h();
    }

    public h() {
        Object[][] r0 = d;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        Object[] r4 = r0[r3];
        a(((Integer) ZeusTransformUtils.preCheckCast(r4[0], Integer.class, "com.obric.memorydata.plugin")).intValue(), r4[1].toString());
        r3 = r3 + 1;
        goto L3
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        return com.tom_roush.pdfbox.a.i.hB;
    }
}
