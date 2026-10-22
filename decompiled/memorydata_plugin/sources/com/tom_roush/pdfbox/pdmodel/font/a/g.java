package com.tom_roush.pdfbox.pdmodel.font.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.crash.NpthBus;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.tracker.fragment.BuildConfig;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.loc.o;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.cae.userAware.WifiScanSceneType;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes6.dex */
public class g extends c {
    private static final Object[][] c = null;
    public static final g d = null;

    static {
        c = new Object[][]{new Object[]{65, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS}, new Object[]{174, "AE"}, new Object[]{231, "Aacute"}, new Object[]{229, "Acircumflex"}, new Object[]{128, "Adieresis"}, new Object[]{203, "Agrave"}, new Object[]{129, "Aring"}, new Object[]{204, "Atilde"}, new Object[]{66, "B"}, new Object[]{67, "C"}, new Object[]{130, "Ccedilla"}, new Object[]{68, com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b}, new Object[]{69, ExifInterface.LONGITUDE_EAST}, new Object[]{131, "Eacute"}, new Object[]{230, "Ecircumflex"}, new Object[]{232, "Edieresis"}, new Object[]{233, "Egrave"}, new Object[]{70, "F"}, new Object[]{71, NpthBus.UUID_SUFIX_3_1_3}, new Object[]{72, com.tom_roush.pdfbox.pdmodel.a.d.i.n}, new Object[]{73, "I"}, new Object[]{234, "Iacute"}, new Object[]{235, "Icircumflex"}, new Object[]{236, "Idieresis"}, new Object[]{237, "Igrave"}, new Object[]{74, "J"}, new Object[]{75, "K"}, new Object[]{76, com.tom_roush.pdfbox.pdmodel.a.d.i.u}, new Object[]{77, "M"}, new Object[]{78, "N"}, new Object[]{132, "Ntilde"}, new Object[]{79, "O"}, new Object[]{206, "OE"}, new Object[]{238, "Oacute"}, new Object[]{239, "Ocircumflex"}, new Object[]{133, "Odieresis"}, new Object[]{241, "Ograve"}, new Object[]{175, "Oslash"}, new Object[]{205, "Otilde"}, new Object[]{80, com.tom_roush.pdfbox.pdmodel.a.d.i.m}, new Object[]{81, "Q"}, new Object[]{82, "R"}, new Object[]{83, "S"}, new Object[]{84, ExifInterface.GPS_DIRECTION_TRUE}, new Object[]{85, "U"}, new Object[]{242, "Uacute"}, new Object[]{243, "Ucircumflex"}, new Object[]{134, "Udieresis"}, new Object[]{244, "Ugrave"}, new Object[]{86, ExifInterface.GPS_MEASUREMENT_INTERRUPTED}, new Object[]{87, ExifInterface.LONGITUDE_WEST}, new Object[]{88, "X"}, new Object[]{89, "Y"}, new Object[]{217, "Ydieresis"}, new Object[]{90, "Z"}, new Object[]{97, "a"}, new Object[]{135, "aacute"}, new Object[]{137, "acircumflex"}, new Object[]{171, "acute"}, new Object[]{138, "adieresis"}, new Object[]{Integer.valueOf(BuildConfig.VERSION_CODE), "ae"}, new Object[]{136, "agrave"}, new Object[]{38, "ampersand"}, new Object[]{140, "aring"}, new Object[]{94, "asciicircum"}, new Object[]{Integer.valueOf(WebSocketProtocol.PAYLOAD_SHORT), "asciitilde"}, new Object[]{42, "asterisk"}, new Object[]{64, "at"}, new Object[]{139, "atilde"}, new Object[]{98, "b"}, new Object[]{92, "backslash"}, new Object[]{124, "bar"}, new Object[]{123, "braceleft"}, new Object[]{125, "braceright"}, new Object[]{91, "bracketleft"}, new Object[]{93, "bracketright"}, new Object[]{249, "breve"}, new Object[]{165, "bullet"}, new Object[]{99, "c"}, new Object[]{255, "caron"}, new Object[]{141, "ccedilla"}, new Object[]{252, "cedilla"}, new Object[]{162, "cent"}, new Object[]{246, "circumflex"}, new Object[]{58, "colon"}, new Object[]{44, "comma"}, new Object[]{169, "copyright"}, new Object[]{219, "currency"}, new Object[]{100, "d"}, new Object[]{160, "dagger"}, new Object[]{224, "daggerdbl"}, new Object[]{161, "degree"}, new Object[]{172, "dieresis"}, new Object[]{Integer.valueOf(Constants.UPLOAD_DISASTER_ESCAPE), "divide"}, new Object[]{36, "dollar"}, new Object[]{Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION), "dotaccent"}, new Object[]{245, "dotlessi"}, new Object[]{101, "e"}, new Object[]{142, "eacute"}, new Object[]{144, "ecircumflex"}, new Object[]{145, "edieresis"}, new Object[]{143, "egrave"}, new Object[]{56, "eight"}, new Object[]{201, "ellipsis"}, new Object[]{209, "emdash"}, new Object[]{208, "endash"}, new Object[]{61, "equal"}, new Object[]{33, "exclam"}, new Object[]{193, "exclamdown"}, new Object[]{102, com.bytedance.apm.util.f.f1488a}, new Object[]{222, "fi"}, new Object[]{53, "five"}, new Object[]{223, "fl"}, new Object[]{196, "florin"}, new Object[]{52, "four"}, new Object[]{218, "fraction"}, new Object[]{103, o.f}, new Object[]{167, "germandbls"}, new Object[]{96, "grave"}, new Object[]{62, "greater"}, new Object[]{Integer.valueOf(WifiScanSceneType.HAR_END), "guillemotleft"}, new Object[]{200, "guillemotright"}, new Object[]{220, "guilsinglleft"}, new Object[]{221, "guilsinglright"}, new Object[]{104, o.g}, new Object[]{253, "hungarumlaut"}, new Object[]{45, "hyphen"}, new Object[]{105, "i"}, new Object[]{146, "iacute"}, new Object[]{148, "icircumflex"}, new Object[]{149, "idieresis"}, new Object[]{147, "igrave"}, new Object[]{106, o.j}, new Object[]{107, "k"}, new Object[]{108, "l"}, new Object[]{60, "less"}, new Object[]{194, "logicalnot"}, new Object[]{109, "m"}, new Object[]{248, "macron"}, new Object[]{181, "mu"}, new Object[]{110, "n"}, new Object[]{57, "nine"}, new Object[]{Integer.valueOf(AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD), "ntilde"}, new Object[]{35, "numbersign"}, new Object[]{111, "o"}, new Object[]{151, "oacute"}, new Object[]{153, "ocircumflex"}, new Object[]{154, "odieresis"}, new Object[]{Integer.valueOf(Constants.UPLOAD_HTTP_ERROR), "oe"}, new Object[]{254, "ogonek"}, new Object[]{152, "ograve"}, new Object[]{49, "one"}, new Object[]{187, "ordfeminine"}, new Object[]{188, "ordmasculine"}, new Object[]{191, "oslash"}, new Object[]{155, "otilde"}, new Object[]{112, "p"}, new Object[]{166, "paragraph"}, new Object[]{40, "parenleft"}, new Object[]{41, "parenright"}, new Object[]{37, "percent"}, new Object[]{46, TypedValues.CycleType.S_WAVE_PERIOD}, new Object[]{225, "periodcentered"}, new Object[]{228, "perthousand"}, new Object[]{43, "plus"}, new Object[]{177, "plusminus"}, new Object[]{113, "q"}, new Object[]{63, "question"}, new Object[]{192, "questiondown"}, new Object[]{34, "quotedbl"}, new Object[]{227, "quotedblbase"}, new Object[]{210, "quotedblleft"}, new Object[]{211, "quotedblright"}, new Object[]{212, "quoteleft"}, new Object[]{Integer.valueOf(Constants.UPLOAD_DISASTER_DROP), "quoteright"}, new Object[]{226, "quotesinglbase"}, new Object[]{39, "quotesingle"}, new Object[]{114, "r"}, new Object[]{168, "registered"}, new Object[]{251, "ring"}, new Object[]{115, "s"}, new Object[]{164, "section"}, new Object[]{59, "semicolon"}, new Object[]{55, "seven"}, new Object[]{54, "six"}, new Object[]{47, "slash"}, new Object[]{32, "space"}, new Object[]{163, "sterling"}, new Object[]{116, "t"}, new Object[]{51, "three"}, new Object[]{247, "tilde"}, new Object[]{170, "trademark"}, new Object[]{50, "two"}, new Object[]{117, "u"}, new Object[]{156, "uacute"}, new Object[]{158, "ucircumflex"}, new Object[]{159, "udieresis"}, new Object[]{157, "ugrave"}, new Object[]{95, "underscore"}, new Object[]{118, BaseSwitches.V}, new Object[]{Integer.valueOf(IdlErrors.E_RejectInferDeviceOverheat), "w"}, new Object[]{120, "x"}, new Object[]{121, "y"}, new Object[]{216, "ydieresis"}, new Object[]{Integer.valueOf(SubsamplingScaleImageView.ORIENTATION_180), "yen"}, new Object[]{122, "z"}, new Object[]{48, "zero"}, new Object[]{202, "nbspace"}};
        d = new g();
    }

    public g() {
        Object[][] r0 = c;
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
        return com.tom_roush.pdfbox.a.i.eN;
    }
}
