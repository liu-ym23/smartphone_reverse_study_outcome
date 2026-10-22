package com.tom_roush.fontbox.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.NpthBus;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.tracker.fragment.BuildConfig;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.cae.userAware.WifiScanSceneType;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes6.dex */
public final class i extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object[][] f15910a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final i f15911b = null;

    static {
        Object[][] r0 = {new Object[]{0, ".notdef"}, new Object[]{1, "space"}, new Object[]{2, "exclam"}, new Object[]{3, "quotedbl"}, new Object[]{4, "numbersign"}, new Object[]{5, "dollar"}, new Object[]{6, "percent"}, new Object[]{7, "ampersand"}, new Object[]{8, "quoteright"}, new Object[]{9, "parenleft"}, new Object[]{10, "parenright"}, new Object[]{11, "asterisk"}, new Object[]{12, "plus"}, new Object[]{13, "comma"}, new Object[]{14, "hyphen"}, new Object[]{15, TypedValues.CycleType.S_WAVE_PERIOD}, new Object[]{16, "slash"}, new Object[]{17, "zero"}, new Object[]{18, "one"}, new Object[]{19, "two"}, new Object[]{20, "three"}, new Object[]{21, "four"}, new Object[]{22, "five"}, new Object[]{23, "six"}, new Object[]{24, "seven"}, new Object[]{25, "eight"}, new Object[]{26, "nine"}, new Object[]{27, "colon"}, new Object[]{28, "semicolon"}, new Object[]{29, "less"}, new Object[]{30, "equal"}, new Object[]{31, "greater"}, new Object[]{32, "question"}, new Object[]{33, "at"}, new Object[]{34, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS}, new Object[]{35, "B"}, new Object[]{36, "C"}, new Object[]{37, com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b}, new Object[]{38, ExifInterface.LONGITUDE_EAST}, new Object[]{39, "F"}, new Object[]{40, NpthBus.UUID_SUFIX_3_1_3}, new Object[]{41, com.tom_roush.pdfbox.pdmodel.a.d.i.n}, new Object[]{42, "I"}, new Object[]{43, "J"}, new Object[]{44, "K"}, new Object[]{45, com.tom_roush.pdfbox.pdmodel.a.d.i.u}, new Object[]{46, "M"}, new Object[]{47, "N"}, new Object[]{48, "O"}, new Object[]{49, com.tom_roush.pdfbox.pdmodel.a.d.i.m}, new Object[]{50, "Q"}, new Object[]{51, "R"}, new Object[]{52, "S"}, new Object[]{53, ExifInterface.GPS_DIRECTION_TRUE}, new Object[]{54, "U"}, new Object[]{55, ExifInterface.GPS_MEASUREMENT_INTERRUPTED}, new Object[]{56, ExifInterface.LONGITUDE_WEST}, new Object[]{57, "X"}, new Object[]{58, "Y"}, new Object[]{59, "Z"}, new Object[]{60, "bracketleft"}, new Object[]{61, "backslash"}, new Object[]{62, "bracketright"}, new Object[]{63, "asciicircum"}, new Object[]{64, "underscore"}, new Object[]{65, "quoteleft"}, new Object[]{66, "a"}, new Object[]{67, "b"}, new Object[]{68, "c"}, new Object[]{69, "d"}, new Object[]{70, "e"}, new Object[]{71, com.bytedance.apm.util.f.f1488a}, new Object[]{72, com.loc.o.f}, new Object[]{73, com.loc.o.g}, new Object[]{74, "i"}, new Object[]{75, com.loc.o.j}, new Object[]{76, "k"}, new Object[]{77, "l"}, new Object[]{78, "m"}, new Object[]{79, "n"}, new Object[]{80, "o"}, new Object[]{81, "p"}, new Object[]{82, "q"}, new Object[]{83, "r"}, new Object[]{84, "s"}, new Object[]{85, "t"}, new Object[]{86, "u"}, new Object[]{87, BaseSwitches.V}, new Object[]{88, "w"}, new Object[]{89, "x"}, new Object[]{90, "y"}, new Object[]{91, "z"}, new Object[]{92, "braceleft"}, new Object[]{93, "bar"}, new Object[]{94, "braceright"}, new Object[]{95, "asciitilde"}, new Object[]{96, "exclamdown"}, new Object[]{97, "cent"}, new Object[]{98, "sterling"}, new Object[]{99, "fraction"}, new Object[]{100, "yen"}, new Object[]{101, "florin"}, new Object[]{102, "section"}, new Object[]{103, "currency"}, new Object[]{104, "quotesingle"}, new Object[]{105, "quotedblleft"}, new Object[]{106, "guillemotleft"}, new Object[]{107, "guilsinglleft"}, new Object[]{108, "guilsinglright"}, new Object[]{109, "fi"}, new Object[]{110, "fl"}, new Object[]{111, "endash"}, new Object[]{112, "dagger"}, new Object[]{113, "daggerdbl"}, new Object[]{114, "periodcentered"}, new Object[]{115, "paragraph"}, new Object[]{116, "bullet"}, new Object[]{117, "quotesinglbase"}, new Object[]{118, "quotedblbase"}, new Object[]{Integer.valueOf(IdlErrors.E_RejectInferDeviceOverheat), "quotedblright"}, new Object[]{120, "guillemotright"}, new Object[]{121, "ellipsis"}, new Object[]{122, "perthousand"}, new Object[]{123, "questiondown"}, new Object[]{124, "grave"}, new Object[]{125, "acute"}, new Object[]{Integer.valueOf(WebSocketProtocol.PAYLOAD_SHORT), "circumflex"}, new Object[]{127, "tilde"}, new Object[]{128, "macron"}, new Object[]{129, "breve"}, new Object[]{130, "dotaccent"}, new Object[]{131, "dieresis"}, new Object[]{132, "ring"}, new Object[]{133, "cedilla"}, new Object[]{134, "hungarumlaut"}, new Object[]{135, "ogonek"}, new Object[]{136, "caron"}, new Object[]{137, "emdash"}, new Object[]{138, "AE"}, new Object[]{139, "ordfeminine"}, new Object[]{140, "Lslash"}, new Object[]{141, "Oslash"}, new Object[]{142, "OE"}, new Object[]{143, "ordmasculine"}, new Object[]{144, "ae"}, new Object[]{145, "dotlessi"}, new Object[]{146, "lslash"}, new Object[]{147, "oslash"}, new Object[]{148, "oe"}, new Object[]{149, "germandbls"}, new Object[]{Integer.valueOf(AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD), "onesuperior"}, new Object[]{151, "logicalnot"}, new Object[]{152, "mu"}, new Object[]{153, "trademark"}, new Object[]{154, "Eth"}, new Object[]{155, "onehalf"}, new Object[]{156, "plusminus"}, new Object[]{157, "Thorn"}, new Object[]{158, "onequarter"}, new Object[]{159, "divide"}, new Object[]{160, "brokenbar"}, new Object[]{161, "degree"}, new Object[]{162, "thorn"}, new Object[]{163, "threequarters"}, new Object[]{164, "twosuperior"}, new Object[]{165, "registered"}, new Object[]{166, "minus"}, new Object[]{167, "eth"}, new Object[]{168, "multiply"}, new Object[]{169, "threesuperior"}, new Object[]{170, "copyright"}, new Object[]{171, "Aacute"}, new Object[]{172, "Acircumflex"}, new Object[]{173, "Adieresis"}, new Object[]{174, "Agrave"}, new Object[]{175, "Aring"}, new Object[]{176, "Atilde"}, new Object[]{177, "Ccedilla"}, new Object[]{178, "Eacute"}, new Object[]{179, "Ecircumflex"}, new Object[]{Integer.valueOf(SubsamplingScaleImageView.ORIENTATION_180), "Edieresis"}, new Object[]{181, "Egrave"}, new Object[]{182, "Iacute"}, new Object[]{183, "Icircumflex"}, new Object[]{184, "Idieresis"}, new Object[]{185, "Igrave"}, new Object[]{186, "Ntilde"}, new Object[]{187, "Oacute"}, new Object[]{188, "Ocircumflex"}, new Object[]{189, "Odieresis"}, new Object[]{Integer.valueOf(BuildConfig.VERSION_CODE), "Ograve"}, new Object[]{191, "Otilde"}, new Object[]{192, "Scaron"}, new Object[]{193, "Uacute"}, new Object[]{194, "Ucircumflex"}, new Object[]{195, "Udieresis"}, new Object[]{196, "Ugrave"}, new Object[]{197, "Yacute"}, new Object[]{198, "Ydieresis"}, new Object[]{Integer.valueOf(WifiScanSceneType.HAR_END), "Zcaron"}, new Object[]{200, "aacute"}, new Object[]{201, "acircumflex"}, new Object[]{202, "adieresis"}, new Object[]{203, "agrave"}, new Object[]{204, "aring"}, new Object[]{205, "atilde"}, new Object[]{206, "ccedilla"}, new Object[]{Integer.valueOf(Constants.UPLOAD_HTTP_ERROR), "eacute"}, new Object[]{208, "ecircumflex"}, new Object[]{209, "edieresis"}, new Object[]{210, "egrave"}, new Object[]{211, "iacute"}, new Object[]{212, "icircumflex"}, new Object[]{Integer.valueOf(Constants.UPLOAD_DISASTER_DROP), "idieresis"}, new Object[]{Integer.valueOf(Constants.UPLOAD_DISASTER_ESCAPE), "igrave"}, new Object[]{215, "ntilde"}, new Object[]{216, "oacute"}, new Object[]{217, "ocircumflex"}, new Object[]{218, "odieresis"}, new Object[]{219, "ograve"}, new Object[]{220, "otilde"}, new Object[]{221, "scaron"}, new Object[]{222, "uacute"}, new Object[]{223, "ucircumflex"}, new Object[]{224, "udieresis"}, new Object[]{225, "ugrave"}, new Object[]{226, "yacute"}, new Object[]{227, "ydieresis"}, new Object[]{228, "zcaron"}};
        f15910a = r0;
        f15911b = new i();
        int r1 = r0.length;
        int r2 = 0;
        int r4 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Object[] r6 = r0[r2];
        f15911b.a(r4, ((Integer) ZeusTransformUtils.preCheckCast(r6[0], Integer.class, "com.obric.memorydata.plugin")).intValue(), r6[1].toString());
        r2 = r2 + 1;
        r4 = r4 + 1;
        goto L3
    }

    private i() {
        super(false);
    }

    public static i b() {
        return f15911b;
    }
}
