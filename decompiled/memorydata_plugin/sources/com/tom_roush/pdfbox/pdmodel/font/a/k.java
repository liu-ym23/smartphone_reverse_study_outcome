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
public class k extends c {
    public static final k c = null;
    private static final Object[][] d = null;

    static {
        d = new Object[][]{new Object[]{65, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS}, new Object[]{198, "AE"}, new Object[]{193, "Aacute"}, new Object[]{194, "Acircumflex"}, new Object[]{196, "Adieresis"}, new Object[]{192, "Agrave"}, new Object[]{197, "Aring"}, new Object[]{195, "Atilde"}, new Object[]{66, "B"}, new Object[]{67, "C"}, new Object[]{Integer.valueOf(WifiScanSceneType.HAR_END), "Ccedilla"}, new Object[]{68, com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b}, new Object[]{69, ExifInterface.LONGITUDE_EAST}, new Object[]{201, "Eacute"}, new Object[]{202, "Ecircumflex"}, new Object[]{203, "Edieresis"}, new Object[]{200, "Egrave"}, new Object[]{208, "Eth"}, new Object[]{128, "Euro"}, new Object[]{70, "F"}, new Object[]{71, NpthBus.UUID_SUFIX_3_1_3}, new Object[]{72, com.tom_roush.pdfbox.pdmodel.a.d.i.n}, new Object[]{73, "I"}, new Object[]{205, "Iacute"}, new Object[]{206, "Icircumflex"}, new Object[]{Integer.valueOf(Constants.UPLOAD_HTTP_ERROR), "Idieresis"}, new Object[]{204, "Igrave"}, new Object[]{74, "J"}, new Object[]{75, "K"}, new Object[]{76, com.tom_roush.pdfbox.pdmodel.a.d.i.u}, new Object[]{77, "M"}, new Object[]{78, "N"}, new Object[]{209, "Ntilde"}, new Object[]{79, "O"}, new Object[]{140, "OE"}, new Object[]{211, "Oacute"}, new Object[]{212, "Ocircumflex"}, new Object[]{Integer.valueOf(Constants.UPLOAD_DISASTER_ESCAPE), "Odieresis"}, new Object[]{210, "Ograve"}, new Object[]{216, "Oslash"}, new Object[]{Integer.valueOf(Constants.UPLOAD_DISASTER_DROP), "Otilde"}, new Object[]{80, com.tom_roush.pdfbox.pdmodel.a.d.i.m}, new Object[]{81, "Q"}, new Object[]{82, "R"}, new Object[]{83, "S"}, new Object[]{138, "Scaron"}, new Object[]{84, ExifInterface.GPS_DIRECTION_TRUE}, new Object[]{222, "Thorn"}, new Object[]{85, "U"}, new Object[]{218, "Uacute"}, new Object[]{219, "Ucircumflex"}, new Object[]{220, "Udieresis"}, new Object[]{217, "Ugrave"}, new Object[]{86, ExifInterface.GPS_MEASUREMENT_INTERRUPTED}, new Object[]{87, ExifInterface.LONGITUDE_WEST}, new Object[]{88, "X"}, new Object[]{89, "Y"}, new Object[]{221, "Yacute"}, new Object[]{159, "Ydieresis"}, new Object[]{90, "Z"}, new Object[]{142, "Zcaron"}, new Object[]{97, "a"}, new Object[]{225, "aacute"}, new Object[]{226, "acircumflex"}, new Object[]{Integer.valueOf(SubsamplingScaleImageView.ORIENTATION_180), "acute"}, new Object[]{228, "adieresis"}, new Object[]{230, "ae"}, new Object[]{224, "agrave"}, new Object[]{38, "ampersand"}, new Object[]{229, "aring"}, new Object[]{94, "asciicircum"}, new Object[]{Integer.valueOf(WebSocketProtocol.PAYLOAD_SHORT), "asciitilde"}, new Object[]{42, "asterisk"}, new Object[]{64, "at"}, new Object[]{227, "atilde"}, new Object[]{98, "b"}, new Object[]{92, "backslash"}, new Object[]{124, "bar"}, new Object[]{123, "braceleft"}, new Object[]{125, "braceright"}, new Object[]{91, "bracketleft"}, new Object[]{93, "bracketright"}, new Object[]{166, "brokenbar"}, new Object[]{149, "bullet"}, new Object[]{99, "c"}, new Object[]{231, "ccedilla"}, new Object[]{184, "cedilla"}, new Object[]{162, "cent"}, new Object[]{136, "circumflex"}, new Object[]{58, "colon"}, new Object[]{44, "comma"}, new Object[]{169, "copyright"}, new Object[]{164, "currency"}, new Object[]{100, "d"}, new Object[]{134, "dagger"}, new Object[]{135, "daggerdbl"}, new Object[]{176, "degree"}, new Object[]{168, "dieresis"}, new Object[]{247, "divide"}, new Object[]{36, "dollar"}, new Object[]{101, "e"}, new Object[]{233, "eacute"}, new Object[]{234, "ecircumflex"}, new Object[]{235, "edieresis"}, new Object[]{232, "egrave"}, new Object[]{56, "eight"}, new Object[]{133, "ellipsis"}, new Object[]{151, "emdash"}, new Object[]{Integer.valueOf(AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD), "endash"}, new Object[]{61, "equal"}, new Object[]{240, "eth"}, new Object[]{33, "exclam"}, new Object[]{161, "exclamdown"}, new Object[]{102, com.bytedance.apm.util.f.f1488a}, new Object[]{53, "five"}, new Object[]{131, "florin"}, new Object[]{52, "four"}, new Object[]{103, o.f}, new Object[]{223, "germandbls"}, new Object[]{96, "grave"}, new Object[]{62, "greater"}, new Object[]{171, "guillemotleft"}, new Object[]{187, "guillemotright"}, new Object[]{139, "guilsinglleft"}, new Object[]{155, "guilsinglright"}, new Object[]{104, o.g}, new Object[]{45, "hyphen"}, new Object[]{105, "i"}, new Object[]{237, "iacute"}, new Object[]{238, "icircumflex"}, new Object[]{239, "idieresis"}, new Object[]{236, "igrave"}, new Object[]{106, o.j}, new Object[]{107, "k"}, new Object[]{108, "l"}, new Object[]{60, "less"}, new Object[]{172, "logicalnot"}, new Object[]{109, "m"}, new Object[]{175, "macron"}, new Object[]{181, "mu"}, new Object[]{215, "multiply"}, new Object[]{110, "n"}, new Object[]{57, "nine"}, new Object[]{241, "ntilde"}, new Object[]{35, "numbersign"}, new Object[]{111, "o"}, new Object[]{243, "oacute"}, new Object[]{244, "ocircumflex"}, new Object[]{246, "odieresis"}, new Object[]{156, "oe"}, new Object[]{242, "ograve"}, new Object[]{49, "one"}, new Object[]{189, "onehalf"}, new Object[]{188, "onequarter"}, new Object[]{185, "onesuperior"}, new Object[]{170, "ordfeminine"}, new Object[]{186, "ordmasculine"}, new Object[]{248, "oslash"}, new Object[]{245, "otilde"}, new Object[]{112, "p"}, new Object[]{182, "paragraph"}, new Object[]{40, "parenleft"}, new Object[]{41, "parenright"}, new Object[]{37, "percent"}, new Object[]{46, TypedValues.CycleType.S_WAVE_PERIOD}, new Object[]{183, "periodcentered"}, new Object[]{137, "perthousand"}, new Object[]{43, "plus"}, new Object[]{177, "plusminus"}, new Object[]{113, "q"}, new Object[]{63, "question"}, new Object[]{191, "questiondown"}, new Object[]{34, "quotedbl"}, new Object[]{132, "quotedblbase"}, new Object[]{147, "quotedblleft"}, new Object[]{148, "quotedblright"}, new Object[]{145, "quoteleft"}, new Object[]{146, "quoteright"}, new Object[]{130, "quotesinglbase"}, new Object[]{39, "quotesingle"}, new Object[]{114, "r"}, new Object[]{174, "registered"}, new Object[]{115, "s"}, new Object[]{154, "scaron"}, new Object[]{167, "section"}, new Object[]{59, "semicolon"}, new Object[]{55, "seven"}, new Object[]{54, "six"}, new Object[]{47, "slash"}, new Object[]{32, "space"}, new Object[]{163, "sterling"}, new Object[]{116, "t"}, new Object[]{254, "thorn"}, new Object[]{51, "three"}, new Object[]{Integer.valueOf(BuildConfig.VERSION_CODE), "threequarters"}, new Object[]{179, "threesuperior"}, new Object[]{152, "tilde"}, new Object[]{153, "trademark"}, new Object[]{50, "two"}, new Object[]{178, "twosuperior"}, new Object[]{117, "u"}, new Object[]{Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION), "uacute"}, new Object[]{251, "ucircumflex"}, new Object[]{252, "udieresis"}, new Object[]{249, "ugrave"}, new Object[]{95, "underscore"}, new Object[]{118, BaseSwitches.V}, new Object[]{Integer.valueOf(IdlErrors.E_RejectInferDeviceOverheat), "w"}, new Object[]{120, "x"}, new Object[]{121, "y"}, new Object[]{253, "yacute"}, new Object[]{255, "ydieresis"}, new Object[]{165, "yen"}, new Object[]{122, "z"}, new Object[]{158, "zcaron"}, new Object[]{48, "zero"}, new Object[]{160, "nbspace"}, new Object[]{173, "sfthyphen"}};
        c = new k();
    }

    public k() {
        Object[][] r0 = d;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        Object[] r4 = r0[r3];
        a(((Integer) ZeusTransformUtils.preCheckCast(r4[0], Integer.class, "com.obric.memorydata.plugin")).intValue(), r4[1].toString());
        r3 = r3 + 1;
        goto L3
    L5:
        int r2 = 33;
    L7:
        if (r2 > 255) goto L12;
        if (this.f16215a.containsKey(Integer.valueOf(r2)) == true) goto L11;
        a(r2, "bullet");
    L11:
        r2 = r2 + 1;
        goto L7
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        return com.tom_roush.pdfbox.a.i.je;
    }
}
