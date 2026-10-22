package org.apache.poi.hwmf.record;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.tracker.fragment.BuildConfig;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.cae.userAware.WifiScanSceneType;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.tom_roush.pdfbox.pdmodel.a.c.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Deque;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes7.dex */
public final enum HwmfTernaryRasterOp extends Enum<HwmfTernaryRasterOp> {
    private static final /* synthetic */ HwmfTernaryRasterOp[] $VALUES = null;
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String[] ARG_ORDER = null;
    public static final HwmfTernaryRasterOp BLACKNESS = null;
    public static final HwmfTernaryRasterOp D = null;
    public static final HwmfTernaryRasterOp DPA = null;
    public static final HwmfTernaryRasterOp DPAN = null;
    public static final HwmfTernaryRasterOp DPNA = null;
    public static final HwmfTernaryRasterOp DPNO = null;
    public static final HwmfTernaryRasterOp DPO = null;
    public static final HwmfTernaryRasterOp DPON = null;
    public static final HwmfTernaryRasterOp DPSAA = null;
    public static final HwmfTernaryRasterOp DPSAAN = null;
    public static final HwmfTernaryRasterOp DPSANA = null;
    public static final HwmfTernaryRasterOp DPSANAN = null;
    public static final HwmfTernaryRasterOp DPSANO = null;
    public static final HwmfTernaryRasterOp DPSAO = null;
    public static final HwmfTernaryRasterOp DPSAON = null;
    public static final HwmfTernaryRasterOp DPSAX = null;
    public static final HwmfTernaryRasterOp DPSAXN = null;
    public static final HwmfTernaryRasterOp DPSDANAX = null;
    public static final HwmfTernaryRasterOp DPSDAOX = null;
    public static final HwmfTernaryRasterOp DPSDAOXN = null;
    public static final HwmfTernaryRasterOp DPSDNAOX = null;
    public static final HwmfTernaryRasterOp DPSDNOAX = null;
    public static final HwmfTernaryRasterOp DPSDOAX = null;
    public static final HwmfTernaryRasterOp DPSDOAXN = null;
    public static final HwmfTernaryRasterOp DPSDONOX = null;
    public static final HwmfTernaryRasterOp DPSDPAOXX = null;
    public static final HwmfTernaryRasterOp DPSDPOAXX = null;
    public static final HwmfTernaryRasterOp DPSDXAX = null;
    public static final HwmfTernaryRasterOp DPSDXOX = null;
    public static final HwmfTernaryRasterOp DPSDXOXN = null;
    public static final HwmfTernaryRasterOp DPSNAA = null;
    public static final HwmfTernaryRasterOp DPSNAO = null;
    public static final HwmfTernaryRasterOp DPSNAON = null;
    public static final HwmfTernaryRasterOp DPSNAX = null;
    public static final HwmfTernaryRasterOp DPSNOA = null;
    public static final HwmfTernaryRasterOp DPSNOAN = null;
    public static final HwmfTernaryRasterOp DPSNOX = null;
    public static final HwmfTernaryRasterOp DPSOA = null;
    public static final HwmfTernaryRasterOp DPSOAN = null;
    public static final HwmfTernaryRasterOp DPSONA = null;
    public static final HwmfTernaryRasterOp DPSONO = null;
    public static final HwmfTernaryRasterOp DPSONON = null;
    public static final HwmfTernaryRasterOp DPSOO = null;
    public static final HwmfTernaryRasterOp DPSOON = null;
    public static final HwmfTernaryRasterOp DPSOX = null;
    public static final HwmfTernaryRasterOp DPSOXN = null;
    public static final HwmfTernaryRasterOp DPSXA = null;
    public static final HwmfTernaryRasterOp DPSXAN = null;
    public static final HwmfTernaryRasterOp DPSXNA = null;
    public static final HwmfTernaryRasterOp DPSXNAN = null;
    public static final HwmfTernaryRasterOp DPSXNO = null;
    public static final HwmfTernaryRasterOp DPSXNON = null;
    public static final HwmfTernaryRasterOp DPSXO = null;
    public static final HwmfTernaryRasterOp DPSXON = null;
    public static final HwmfTernaryRasterOp DPSXX = null;
    public static final HwmfTernaryRasterOp DSAN = null;
    public static final HwmfTernaryRasterOp DSNA = null;
    public static final HwmfTernaryRasterOp DSPDAOX = null;
    public static final HwmfTernaryRasterOp DSPDAOXN = null;
    public static final HwmfTernaryRasterOp DSPDOAX = null;
    public static final HwmfTernaryRasterOp DSPDOAXN = null;
    public static final HwmfTernaryRasterOp DSPDSANAXXN = null;
    public static final HwmfTernaryRasterOp DSPDSAOXX = null;
    public static final HwmfTernaryRasterOp DSPDSAOXXN = null;
    public static final HwmfTernaryRasterOp DSPDSOAXX = null;
    public static final HwmfTernaryRasterOp DSPDSOAXXN = null;
    public static final HwmfTernaryRasterOp DSPDSONOXXN = null;
    public static final HwmfTernaryRasterOp DSPDXAX = null;
    public static final HwmfTernaryRasterOp DSPDXAXN = null;
    public static final HwmfTernaryRasterOp DSPDXOX = null;
    public static final HwmfTernaryRasterOp DSPDXOXN = null;
    public static final HwmfTernaryRasterOp DSPNAO = null;
    public static final HwmfTernaryRasterOp DSPNAON = null;
    public static final HwmfTernaryRasterOp DSPNAX = null;
    public static final HwmfTernaryRasterOp DSPNOA = null;
    public static final HwmfTernaryRasterOp DSPNOAN = null;
    public static final HwmfTernaryRasterOp DSPNOX = null;
    public static final HwmfTernaryRasterOp DSTINVERT = null;
    public static final HwmfTernaryRasterOp DSXN = null;
    public static final HwmfTernaryRasterOp MERGECOPY = null;
    public static final HwmfTernaryRasterOp MERGEPAINT = null;
    public static final HwmfTernaryRasterOp NOTSRCCOPY = null;
    public static final HwmfTernaryRasterOp NOTSRCERASE = null;
    private static final String OPS = "nxoa";
    public static final HwmfTernaryRasterOp PATCOPY = null;
    public static final HwmfTernaryRasterOp PATINVERT = null;
    public static final HwmfTernaryRasterOp PATPAINT = null;
    public static final HwmfTernaryRasterOp PDNA = null;
    public static final HwmfTernaryRasterOp PDNO = null;
    public static final HwmfTernaryRasterOp PDSANA = null;
    public static final HwmfTernaryRasterOp PDSANAN = null;
    public static final HwmfTernaryRasterOp PDSANO = null;
    public static final HwmfTernaryRasterOp PDSAO = null;
    public static final HwmfTernaryRasterOp PDSAON = null;
    public static final HwmfTernaryRasterOp PDSAX = null;
    public static final HwmfTernaryRasterOp PDSAXN = null;
    public static final HwmfTernaryRasterOp PDSNAO = null;
    public static final HwmfTernaryRasterOp PDSNAON = null;
    public static final HwmfTernaryRasterOp PDSNAX = null;
    public static final HwmfTernaryRasterOp PDSNOA = null;
    public static final HwmfTernaryRasterOp PDSNOAN = null;
    public static final HwmfTernaryRasterOp PDSNOX = null;
    public static final HwmfTernaryRasterOp PDSOA = null;
    public static final HwmfTernaryRasterOp PDSOAN = null;
    public static final HwmfTernaryRasterOp PDSONA = null;
    public static final HwmfTernaryRasterOp PDSONO = null;
    public static final HwmfTernaryRasterOp PDSONON = null;
    public static final HwmfTernaryRasterOp PDSOX = null;
    public static final HwmfTernaryRasterOp PDSOXN = null;
    public static final HwmfTernaryRasterOp PDSPANAXN = null;
    public static final HwmfTernaryRasterOp PDSPAOX = null;
    public static final HwmfTernaryRasterOp PDSPAOXN = null;
    public static final HwmfTernaryRasterOp PDSPDAOXXN = null;
    public static final HwmfTernaryRasterOp PDSPDOAXXN = null;
    public static final HwmfTernaryRasterOp PDSPNAOXN = null;
    public static final HwmfTernaryRasterOp PDSPNOAXN = null;
    public static final HwmfTernaryRasterOp PDSPOAX = null;
    public static final HwmfTernaryRasterOp PDSPOAXN = null;
    public static final HwmfTernaryRasterOp PDSPONOXN = null;
    public static final HwmfTernaryRasterOp PDSPXAX = null;
    public static final HwmfTernaryRasterOp PDSPXOX = null;
    public static final HwmfTernaryRasterOp PDSPXOXN = null;
    public static final HwmfTernaryRasterOp PDSXA = null;
    public static final HwmfTernaryRasterOp PDSXAN = null;
    public static final HwmfTernaryRasterOp PDSXNA = null;
    public static final HwmfTernaryRasterOp PDSXNAN = null;
    public static final HwmfTernaryRasterOp PDSXNO = null;
    public static final HwmfTernaryRasterOp PDSXNON = null;
    public static final HwmfTernaryRasterOp PDSXO = null;
    public static final HwmfTernaryRasterOp PDSXON = null;
    public static final HwmfTernaryRasterOp PDSXXN = null;
    public static final HwmfTernaryRasterOp PDXN = null;
    public static final HwmfTernaryRasterOp PN = null;
    public static final HwmfTernaryRasterOp PSAN = null;
    public static final HwmfTernaryRasterOp PSDNAA = null;
    public static final HwmfTernaryRasterOp PSDNAO = null;
    public static final HwmfTernaryRasterOp PSDNAON = null;
    public static final HwmfTernaryRasterOp PSDNAX = null;
    public static final HwmfTernaryRasterOp PSDNOA = null;
    public static final HwmfTernaryRasterOp PSDNOAN = null;
    public static final HwmfTernaryRasterOp PSDNOO = null;
    public static final HwmfTernaryRasterOp PSDNOX = null;
    public static final HwmfTernaryRasterOp PSDPAOX = null;
    public static final HwmfTernaryRasterOp PSDPAOXN = null;
    public static final HwmfTernaryRasterOp PSDPOAX = null;
    public static final HwmfTernaryRasterOp PSDPOAXN = null;
    public static final HwmfTernaryRasterOp PSDPSANAXX = null;
    public static final HwmfTernaryRasterOp PSDPSAOXX = null;
    public static final HwmfTernaryRasterOp PSDPSAOXXN = null;
    public static final HwmfTernaryRasterOp PSDPSOAXX = null;
    public static final HwmfTernaryRasterOp PSDPSOAXXN = null;
    public static final HwmfTernaryRasterOp PSDPSONOXX = null;
    public static final HwmfTernaryRasterOp PSDPXAX = null;
    public static final HwmfTernaryRasterOp PSDPXAXN = null;
    public static final HwmfTernaryRasterOp PSDPXOX = null;
    public static final HwmfTernaryRasterOp PSDPXOXN = null;
    public static final HwmfTernaryRasterOp PSNA = null;
    public static final HwmfTernaryRasterOp PSNO = null;
    public static final HwmfTernaryRasterOp PSO = null;
    public static final HwmfTernaryRasterOp PSON = null;
    public static final HwmfTernaryRasterOp PSX = null;
    public static final HwmfTernaryRasterOp PSXN = null;
    public static final HwmfTernaryRasterOp SDNO = null;
    public static final HwmfTernaryRasterOp SDPANA = null;
    public static final HwmfTernaryRasterOp SDPANAN = null;
    public static final HwmfTernaryRasterOp SDPANO = null;
    public static final HwmfTernaryRasterOp SDPAO = null;
    public static final HwmfTernaryRasterOp SDPAON = null;
    public static final HwmfTernaryRasterOp SDPAX = null;
    public static final HwmfTernaryRasterOp SDPNAA = null;
    public static final HwmfTernaryRasterOp SDPNAO = null;
    public static final HwmfTernaryRasterOp SDPNAON = null;
    public static final HwmfTernaryRasterOp SDPNAX = null;
    public static final HwmfTernaryRasterOp SDPNOA = null;
    public static final HwmfTernaryRasterOp SDPNOAN = null;
    public static final HwmfTernaryRasterOp SDPNOO = null;
    public static final HwmfTernaryRasterOp SDPNOX = null;
    public static final HwmfTernaryRasterOp SDPOA = null;
    public static final HwmfTernaryRasterOp SDPOAN = null;
    public static final HwmfTernaryRasterOp SDPONA = null;
    public static final HwmfTernaryRasterOp SDPONO = null;
    public static final HwmfTernaryRasterOp SDPOX = null;
    public static final HwmfTernaryRasterOp SDPSANAX = null;
    public static final HwmfTernaryRasterOp SDPSANAXN = null;
    public static final HwmfTernaryRasterOp SDPSAOX = null;
    public static final HwmfTernaryRasterOp SDPSAOXN = null;
    public static final HwmfTernaryRasterOp SDPSNAOX = null;
    public static final HwmfTernaryRasterOp SDPSNAOXN = null;
    public static final HwmfTernaryRasterOp SDPSNOAX = null;
    public static final HwmfTernaryRasterOp SDPSNOAXN = null;
    public static final HwmfTernaryRasterOp SDPSOAX = null;
    public static final HwmfTernaryRasterOp SDPSOAXN = null;
    public static final HwmfTernaryRasterOp SDPSONOX = null;
    public static final HwmfTernaryRasterOp SDPSONOXN = null;
    public static final HwmfTernaryRasterOp SDPSOOX = null;
    public static final HwmfTernaryRasterOp SDPSXAX = null;
    public static final HwmfTernaryRasterOp SDPSXAXN = null;
    public static final HwmfTernaryRasterOp SDPSXNOX = null;
    public static final HwmfTernaryRasterOp SDPSXOX = null;
    public static final HwmfTernaryRasterOp SDPSXOXN = null;
    public static final HwmfTernaryRasterOp SDPXA = null;
    public static final HwmfTernaryRasterOp SDPXAN = null;
    public static final HwmfTernaryRasterOp SDPXNA = null;
    public static final HwmfTernaryRasterOp SDPXNAN = null;
    public static final HwmfTernaryRasterOp SDPXNO = null;
    public static final HwmfTernaryRasterOp SDPXNON = null;
    public static final HwmfTernaryRasterOp SDPXO = null;
    public static final HwmfTernaryRasterOp SDPXON = null;
    public static final HwmfTernaryRasterOp SDXPDXA = null;
    public static final HwmfTernaryRasterOp SDXPDXAN = null;
    public static final HwmfTernaryRasterOp SPDAXN = null;
    public static final HwmfTernaryRasterOp SPDNAO = null;
    public static final HwmfTernaryRasterOp SPDNAON = null;
    public static final HwmfTernaryRasterOp SPDNAX = null;
    public static final HwmfTernaryRasterOp SPDNOA = null;
    public static final HwmfTernaryRasterOp SPDNOAN = null;
    public static final HwmfTernaryRasterOp SPDNOX = null;
    public static final HwmfTernaryRasterOp SPDOXN = null;
    public static final HwmfTernaryRasterOp SPDSANAX = null;
    public static final HwmfTernaryRasterOp SPDSANAXN = null;
    public static final HwmfTernaryRasterOp SPDSAOX = null;
    public static final HwmfTernaryRasterOp SPDSAOXN = null;
    public static final HwmfTernaryRasterOp SPDSNAOX = null;
    public static final HwmfTernaryRasterOp SPDSNAOXN = null;
    public static final HwmfTernaryRasterOp SPDSNOAX = null;
    public static final HwmfTernaryRasterOp SPDSNOAXN = null;
    public static final HwmfTernaryRasterOp SPDSOAX = null;
    public static final HwmfTernaryRasterOp SPDSOAXN = null;
    public static final HwmfTernaryRasterOp SPDSONOX = null;
    public static final HwmfTernaryRasterOp SPDSONOXN = null;
    public static final HwmfTernaryRasterOp SPDSXAX = null;
    public static final HwmfTernaryRasterOp SPDSXAXN = null;
    public static final HwmfTernaryRasterOp SPDSXNOX = null;
    public static final HwmfTernaryRasterOp SPDSXOX = null;
    public static final HwmfTernaryRasterOp SPDSXOXN = null;
    public static final HwmfTernaryRasterOp SPNA = null;
    public static final HwmfTernaryRasterOp SPNO = null;
    public static final HwmfTernaryRasterOp SPXDSXA = null;
    public static final HwmfTernaryRasterOp SPXDSXAN = null;
    public static final HwmfTernaryRasterOp SPXDSXO = null;
    public static final HwmfTernaryRasterOp SPXDSXON = null;
    public static final HwmfTernaryRasterOp SPXPDXA = null;
    public static final HwmfTernaryRasterOp SPXPDXAN = null;
    public static final HwmfTernaryRasterOp SRCAND = null;
    public static final HwmfTernaryRasterOp SRCCOPY = null;
    public static final HwmfTernaryRasterOp SRCERASE = null;
    public static final HwmfTernaryRasterOp SRCINVERT = null;
    public static final HwmfTernaryRasterOp SRCPAINT = null;
    public static final HwmfTernaryRasterOp SSDXPDXAX = null;
    public static final HwmfTernaryRasterOp SSDXPDXAXN = null;
    public static final HwmfTernaryRasterOp SSPXDSXAX = null;
    public static final HwmfTernaryRasterOp SSPXDSXAXN = null;
    public static final HwmfTernaryRasterOp SSPXDSXOX = null;
    public static final HwmfTernaryRasterOp SSPXDSXOXN = null;
    public static final HwmfTernaryRasterOp SSPXPDXAX = null;
    public static final HwmfTernaryRasterOp SSPXPDXAXN = null;
    public static final HwmfTernaryRasterOp WHITENESS = null;
    private final int opValue;

    static {
        BLACKNESS = new HwmfTernaryRasterOp("BLACKNESS", 0, 66);
        DPSOON = new HwmfTernaryRasterOp("DPSOON", 1, 66185);
        DPSONA = new HwmfTernaryRasterOp("DPSONA", 2, 134281);
        PSON = new HwmfTernaryRasterOp("PSON", 3, 196778);
        SDPONA = new HwmfTernaryRasterOp("SDPONA", 4, 265352);
        DPON = new HwmfTernaryRasterOp("DPON", 5, 327849);
        PDSXNON = new HwmfTernaryRasterOp("PDSXNON", 6, 395365);
        PDSAON = new HwmfTernaryRasterOp("PDSAON", 7, 459461);
        SDPNAA = new HwmfTernaryRasterOp("SDPNAA", 8, 528136);
        PDSXON = new HwmfTernaryRasterOp("PDSXON", 9, 590405);
        DPNA = new HwmfTernaryRasterOp("DPNA", 10, 656169);
        PSDNAON = new HwmfTernaryRasterOp("PSDNAON", 11, 723754);
        SPNA = new HwmfTernaryRasterOp("SPNA", 12, 787236);
        PDSNAON = new HwmfTernaryRasterOp("PDSNAON", 13, 854821);
        PDSONON = new HwmfTernaryRasterOp("PDSONON", 14, 919717);
        PN = new HwmfTernaryRasterOp("PN", 15, 983041);
        PDSONA = new HwmfTernaryRasterOp("PDSONA", 16, 1051781);
        NOTSRCERASE = new HwmfTernaryRasterOp("NOTSRCERASE", 17, 1114278);
        SDPXNON = new HwmfTernaryRasterOp("SDPXNON", 18, 1181800);
        SDPAON = new HwmfTernaryRasterOp("SDPAON", 19, 1245896);
        DPSXNON = new HwmfTernaryRasterOp("DPSXNON", 20, 1312873);
        DPSAON = new HwmfTernaryRasterOp("DPSAON", 21, 1376969);
        PSDPSANAXX = new HwmfTernaryRasterOp("PSDPSANAXX", 22, 1465546);
        SSPXDSXAXN = new HwmfTernaryRasterOp("SSPXDSXAXN", 23, 1514836);
        SPXPDXA = new HwmfTernaryRasterOp("SPXPDXA", 24, 1576281);
        SDPSANAXN = new HwmfTernaryRasterOp("SDPSANAXN", 25, 1645768);
        PDSPAOX = new HwmfTernaryRasterOp("PDSPAOX", 26, 1705669);
        SDPSXAXN = new HwmfTernaryRasterOp("SDPSXAXN", 27, 1771368);
        PSDPAOX = new HwmfTernaryRasterOp("PSDPAOX", 28, 1836746);
        DSPDXAXN = new HwmfTernaryRasterOp("DSPDXAXN", 29, 1902438);
        PDSOX = new HwmfTernaryRasterOp("PDSOX", 30, 1966501);
        PDSOAN = new HwmfTernaryRasterOp("PDSOAN", 31, 2032517);
        DPSNAA = new HwmfTernaryRasterOp("DPSNAA", 32, 2101001);
        SDPXON = new HwmfTernaryRasterOp("SDPXON", 33, 2163272);
        DSNA = new HwmfTernaryRasterOp("DSNA", 34, 2229030);
        SPDNAON = new HwmfTernaryRasterOp("SPDNAON", 35, 2296612);
        SPXDSXA = new HwmfTernaryRasterOp("SPXDSXA", 36, 2362709);
        PDSPANAXN = new HwmfTernaryRasterOp("PDSPANAXN", 37, 2432197);
        SDPSAOX = new HwmfTernaryRasterOp("SDPSAOX", 38, 2492104);
        SDPSXNOX = new HwmfTernaryRasterOp("SDPSXNOX", 39, 2562152);
        DPSXA = new HwmfTernaryRasterOp("DPSXA", 40, 2622313);
        PSDPSAOXXN = new HwmfTernaryRasterOp("PSDPSAOXXN", 41, 2692810);
        DPSANA = new HwmfTernaryRasterOp("DPSANA", 42, 2755785);
        SSPXPDXAXN = new HwmfTernaryRasterOp("SSPXPDXAXN", 43, 2825560);
        SPDSOAX = new HwmfTernaryRasterOp("SPDSOAX", 44, 2885508);
        PSDNOX = new HwmfTernaryRasterOp("PSDNOX", 45, 2950666);
        PSDPXOX = new HwmfTernaryRasterOp("PSDPXOX", 46, 3016266);
        PSDNOAN = new HwmfTernaryRasterOp("PSDNOAN", 47, 3083818);
        PSNA = new HwmfTernaryRasterOp("PSNA", 48, 3146538);
        SDPNAON = new HwmfTernaryRasterOp("SDPNAON", 49, 3214120);
        SDPSOOX = new HwmfTernaryRasterOp("SDPSOOX", 50, 3278472);
        NOTSRCCOPY = new HwmfTernaryRasterOp("NOTSRCCOPY", 51, 3342344);
        SPDSAOX = new HwmfTernaryRasterOp("SPDSAOX", 52, 3409604);
        SPDSXNOX = new HwmfTernaryRasterOp("SPDSXNOX", 53, 3479652);
        SDPOX = new HwmfTernaryRasterOp("SDPOX", 54, 3539368);
        SDPOAN = new HwmfTernaryRasterOp("SDPOAN", 55, 3605384);
        PSDPOAX = new HwmfTernaryRasterOp("PSDPOAX", 56, 3671946);
        SPDNOX = new HwmfTernaryRasterOp("SPDNOX", 57, 3737092);
        SPDSXOX = new HwmfTernaryRasterOp("SPDSXOX", 58, 3802692);
        SPDNOAN = new HwmfTernaryRasterOp("SPDNOAN", 59, 3870244);
        PSX = new HwmfTernaryRasterOp("PSX", 60, 3932234);
        SPDSONOX = new HwmfTernaryRasterOp("SPDSONOX", 61, 4004004);
        SPDSNAOX = new HwmfTernaryRasterOp("SPDSNAOX", 62, 4070180);
        PSAN = new HwmfTernaryRasterOp("PSAN", 63, 4129002);
        PSDNAA = new HwmfTernaryRasterOp("PSDNAA", 64, 4198154);
        DPSXON = new HwmfTernaryRasterOp("DPSXON", 65, 4260425);
        SDXPDXA = new HwmfTernaryRasterOp("SDXPDXA", 66, 4328797);
        SPDSANAXN = new HwmfTernaryRasterOp("SPDSANAXN", 67, 4398276);
        SRCERASE = new HwmfTernaryRasterOp("SRCERASE", 68, 4457256);
        DPSNAON = new HwmfTernaryRasterOp("DPSNAON", 69, 4524841);
        DSPDAOX = new HwmfTernaryRasterOp("DSPDAOX", 70, 4589254);
        PSDPXAXN = new HwmfTernaryRasterOp("PSDPXAXN", 71, 4654954);
        SDPXA = new HwmfTernaryRasterOp("SDPXA", 72, 4719464);
        PDSPDAOXXN = new HwmfTernaryRasterOp("PDSPDAOXXN", 73, 4789957);
        DPSDOAX = new HwmfTernaryRasterOp("DPSDOAX", 74, 4851593);
        PDSNOX = new HwmfTernaryRasterOp("PDSNOX", 75, 4916741);
        SDPANA = new HwmfTernaryRasterOp("SDPANA", 76, 4984008);
        SSPXDSXOXN = new HwmfTernaryRasterOp("SSPXDSXOXN", 77, 5052756);
        PDSPXOX = new HwmfTernaryRasterOp("PDSPXOX", 78, 5113413);
        PDSNOAN = new HwmfTernaryRasterOp("PDSNOAN", 79, 5180965);
        PDNA = new HwmfTernaryRasterOp("PDNA", 80, 5243685);
        DSPNAON = new HwmfTernaryRasterOp("DSPNAON", 81, 5311270);
        DPSDAOX = new HwmfTernaryRasterOp("DPSDAOX", 82, 5375689);
        SPDSXAXN = new HwmfTernaryRasterOp("SPDSXAXN", 83, 5441380);
        DPSONON = new HwmfTernaryRasterOp("DPSONON", 84, 5507241);
        DSTINVERT = new HwmfTernaryRasterOp("DSTINVERT", 85, 5570569);
        DPSOX = new HwmfTernaryRasterOp("DPSOX", 86, 5636521);
        DPSOAN = new HwmfTernaryRasterOp("DPSOAN", 87, 5702537);
        PDSPOAX = new HwmfTernaryRasterOp("PDSPOAX", 88, 5769093);
        DPSNOX = new HwmfTernaryRasterOp("DPSNOX", 89, 5834249);
        PATINVERT = new HwmfTernaryRasterOp("PATINVERT", 90, 5898313);
        DPSDONOX = new HwmfTernaryRasterOp("DPSDONOX", 91, 5970089);
        DPSDXOX = new HwmfTernaryRasterOp("DPSDXOX", 92, 6030921);
        DPSNOAN = new HwmfTernaryRasterOp("DPSNOAN", 93, 6098473);
        DPSDNAOX = new HwmfTernaryRasterOp("DPSDNAOX", 94, 6167337);
        DPAN = new HwmfTernaryRasterOp("DPAN", 95, 6226153);
        PDSXA = new HwmfTernaryRasterOp("PDSXA", 96, 6292325);
        DSPDSAOXXN = new HwmfTernaryRasterOp("DSPDSAOXXN", 97, 6362822);
        DSPDOAX = new HwmfTernaryRasterOp("DSPDOAX", 98, 6424454);
        SDPNOX = new HwmfTernaryRasterOp("SDPNOX", 99, 6489608);
        SDPSOAX = new HwmfTernaryRasterOp("SDPSOAX", 100, 6555528);
        DSPNOX = new HwmfTernaryRasterOp("DSPNOX", 101, 6620678);
        SRCINVERT = new HwmfTernaryRasterOp("SRCINVERT", 102, 6684742);
        SDPSONOX = new HwmfTernaryRasterOp("SDPSONOX", 103, 6756520);
        DSPDSONOXXN = new HwmfTernaryRasterOp("DSPDSONOXXN", 104, 6838438);
        PDSXXN = new HwmfTernaryRasterOp("PDSXXN", 105, 6881605);
        DPSAX = new HwmfTernaryRasterOp("DPSAX", 106, 6947305);
        PSDPSOAXXN = new HwmfTernaryRasterOp("PSDPSOAXXN", 107, 7018378);
        SDPAX = new HwmfTernaryRasterOp("SDPAX", 108, 7078376);
        PDSPDOAXXN = new HwmfTernaryRasterOp("PDSPDOAXXN", 109, 7149445);
        SDPSNOAX = new HwmfTernaryRasterOp("SDPSNOAX", 110, 7216680);
        PDSXNAN = new HwmfTernaryRasterOp("PDSXNAN", 111, 7277669);
        PDSANA = new HwmfTernaryRasterOp("PDSANA", 112, 7343301);
        SSDXPDXAXN = new HwmfTernaryRasterOp("SSDXPDXAXN", 113, 7413084);
        SDPSXOX = new HwmfTernaryRasterOp("SDPSXOX", 114, 7472712);
        SDPNOAN = new HwmfTernaryRasterOp("SDPNOAN", 115, 7540264);
        DSPDXOX = new HwmfTernaryRasterOp("DSPDXOX", 116, 7603782);
        DSPNOAN = new HwmfTernaryRasterOp("DSPNOAN", 117, 7671334);
        SDPSNAOX = new HwmfTernaryRasterOp("SDPSNAOX", 118, 7740200);
        DSAN = new HwmfTernaryRasterOp("DSAN", IdlErrors.E_RejectInferDeviceOverheat, 7799014);
        PDSAX = new HwmfTernaryRasterOp("PDSAX", 120, 7864805);
        DSPDSOAXXN = new HwmfTernaryRasterOp("DSPDSOAXXN", 121, 7935878);
        DPSDNOAX = new HwmfTernaryRasterOp("DPSDNOAX", 122, 8003113);
        SDPXNAN = new HwmfTernaryRasterOp("SDPXNAN", 123, 8064104);
        SPDSNOAX = new HwmfTernaryRasterOp("SPDSNOAX", 124, 8134180);
        DPSXNAN = new HwmfTernaryRasterOp("DPSXNAN", 125, 8195177);
        SPXDSXO = new HwmfTernaryRasterOp("SPXDSXO", WebSocketProtocol.PAYLOAD_SHORT, 8259925);
        DPSAAN = new HwmfTernaryRasterOp("DPSAAN", 127, 8324041);
        DPSAA = new HwmfTernaryRasterOp("DPSAA", 128, 8389609);
        SPXDSXON = new HwmfTernaryRasterOp("SPXDSXON", 129, 8456565);
        DPSXNA = new HwmfTernaryRasterOp("DPSXNA", 130, 8522825);
        SPDSNOAXN = new HwmfTernaryRasterOp("SPDSNOAXN", 131, 8592900);
        SDPXNA = new HwmfTernaryRasterOp("SDPXNA", 132, 8653896);
        PDSPNOAXN = new HwmfTernaryRasterOp("PDSPNOAXN", 133, 8723973);
        DSPDSOAXX = new HwmfTernaryRasterOp("DSPDSOAXX", 134, 8787878);
        PDSAXN = new HwmfTernaryRasterOp("PDSAXN", 135, 8847813);
        SRCAND = new HwmfTernaryRasterOp("SRCAND", 136, 8913094);
        SDPSNAOXN = new HwmfTernaryRasterOp("SDPSNAOXN", 137, 8985352);
        DSPNOA = new HwmfTernaryRasterOp("DSPNOA", 138, 9047558);
        DSPDXOXN = new HwmfTernaryRasterOp("DSPDXOXN", 139, 9111142);
        SDPNOA = new HwmfTernaryRasterOp("SDPNOA", 140, 9178632);
        SDPSXOXN = new HwmfTernaryRasterOp("SDPSXOXN", 141, 9242216);
        SSDXPDXAX = new HwmfTernaryRasterOp("SSDXPDXAX", 142, 9313660);
        PDSANAN = new HwmfTernaryRasterOp("PDSANAN", 143, 9374949);
        PDSXNA = new HwmfTernaryRasterOp("PDSXNA", 144, 9440325);
        SDPSNOAXN = new HwmfTernaryRasterOp("SDPSNOAXN", 145, 9510408);
        DPSDPOAXX = new HwmfTernaryRasterOp("DPSDPOAXX", 146, 9574313);
        SPDAXN = new HwmfTernaryRasterOp("SPDAXN", 147, 9634244);
        PSDPSOAXX = new HwmfTernaryRasterOp("PSDPSOAXX", 148, 9705386);
        DPSAXN = new HwmfTernaryRasterOp("DPSAXN", 149, 9765321);
        DPSXX = new HwmfTernaryRasterOp("DPSXX", AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD, 9830761);
        PSDPSONOXX = new HwmfTernaryRasterOp("PSDPSONOXX", 151, 9918602);
        SDPSONOXN = new HwmfTernaryRasterOp("SDPSONOXN", 152, 9967752);
        DSXN = new HwmfTernaryRasterOp("DSXN", 153, 10027110);
        DPSNAX = new HwmfTernaryRasterOp("DPSNAX", 154, 10094345);
        SDPSOAXN = new HwmfTernaryRasterOp("SDPSOAXN", 155, 10160040);
        SPDNAX = new HwmfTernaryRasterOp("SPDNAX", 156, 10225412);
        DSPDOAXN = new HwmfTernaryRasterOp("DSPDOAXN", 157, 10291110);
        DSPDSAOXX = new HwmfTernaryRasterOp("DSPDSAOXX", 158, 10360550);
        PDSXAN = new HwmfTernaryRasterOp("PDSXAN", 159, 10421061);
        DPA = new HwmfTernaryRasterOp("DPA", 160, 10485961);
        PDSPNAOXN = new HwmfTernaryRasterOp("PDSPNAOXN", 161, 10558213);
        DPSNOA = new HwmfTernaryRasterOp("DPSNOA", 162, 10620425);
        DPSDXOXN = new HwmfTernaryRasterOp("DPSDXOXN", 163, 10684009);
        PDSPONOXN = new HwmfTernaryRasterOp("PDSPONOXN", 164, 10754181);
        PDXN = new HwmfTernaryRasterOp("PDXN", 165, 10813541);
        DSPNAX = new HwmfTernaryRasterOp("DSPNAX", 166, 10880774);
        PDSPOAXN = new HwmfTernaryRasterOp("PDSPOAXN", 167, 10946469);
        DPSOA = new HwmfTernaryRasterOp("DPSOA", 168, 11010985);
        DPSOXN = new HwmfTernaryRasterOp("DPSOXN", 169, 11075977);
        D = new HwmfTernaryRasterOp(a.f16161b, 170, 11141161);
        DPSONO = new HwmfTernaryRasterOp("DPSONO", 171, 11208841);
        SPDSXAX = new HwmfTernaryRasterOp("SPDSXAX", 172, 11274052);
        DPSDAOXN = new HwmfTernaryRasterOp("DPSDAOXN", 173, 11339497);
        DSPNAO = new HwmfTernaryRasterOp("DSPNAO", 174, 11406086);
        DPNO = new HwmfTernaryRasterOp("DPNO", 175, 11469353);
        PDSNOA = new HwmfTernaryRasterOp("PDSNOA", 176, 11537925);
        PDSPXOXN = new HwmfTernaryRasterOp("PDSPXOXN", 177, 11601509);
        SSPXDSXOX = new HwmfTernaryRasterOp("SSPXDSXOX", 178, 11671924);
        SDPANAN = new HwmfTernaryRasterOp("SDPANAN", 179, 11734248);
        PSDNAX = new HwmfTernaryRasterOp("PSDNAX", SubsamplingScaleImageView.ORIENTATION_180, 11798282);
        DPSDOAXN = new HwmfTernaryRasterOp("DPSDOAXN", 181, 11863977);
        DPSDPAOXX = new HwmfTernaryRasterOp("DPSDPAOXX", 182, 11933417);
        SDPXAN = new HwmfTernaryRasterOp("SDPXAN", 183, 11993928);
        PSDPXAX = new HwmfTernaryRasterOp("PSDPXAX", 184, 12060490);
        DSPDAOXN = new HwmfTernaryRasterOp("DSPDAOXN", 185, 12125926);
        DPSNAO = new HwmfTernaryRasterOp("DPSNAO", 186, 12192521);
        MERGEPAINT = new HwmfTernaryRasterOp("MERGEPAINT", 187, 12255782);
        SPDSANAX = new HwmfTernaryRasterOp("SPDSANAX", 188, 12328164);
        SDXPDXAN = new HwmfTernaryRasterOp("SDXPDXAN", 189, 12389757);
        DPSXO = new HwmfTernaryRasterOp("DPSXO", BuildConfig.VERSION_CODE, 12452457);
        DPSANO = new HwmfTernaryRasterOp("DPSANO", 191, 12519625);
        MERGECOPY = new HwmfTernaryRasterOp("MERGECOPY", 192, 12583114);
        SPDSNAOXN = new HwmfTernaryRasterOp("SPDSNAOXN", 193, 12655364);
        SPDSONOXN = new HwmfTernaryRasterOp("SPDSONOXN", 194, 12720260);
        PSXN = new HwmfTernaryRasterOp("PSXN", 195, 12779626);
        SPDNOA = new HwmfTernaryRasterOp("SPDNOA", 196, 12848644);
        SPDSXOXN = new HwmfTernaryRasterOp("SPDSXOXN", 197, 12912228);
        SDPNAX = new HwmfTernaryRasterOp("SDPNAX", 198, 12977928);
        PSDPOAXN = new HwmfTernaryRasterOp("PSDPOAXN", WifiScanSceneType.HAR_END, 13043626);
        SDPOA = new HwmfTernaryRasterOp("SDPOA", 200, 13108136);
        SPDOXN = new HwmfTernaryRasterOp("SPDOXN", 201, 13173124);
        DPSDXAX = new HwmfTernaryRasterOp("DPSDXAX", 202, 13240137);
        SPDSAOXN = new HwmfTernaryRasterOp("SPDSAOXN", 203, 13305572);
        SRCCOPY = new HwmfTernaryRasterOp("SRCCOPY", 204, 13369376);
        SDPONO = new HwmfTernaryRasterOp("SDPONO", 205, 13437064);
        SDPNAO = new HwmfTernaryRasterOp("SDPNAO", 206, 13503240);
        SPNO = new HwmfTernaryRasterOp("SPNO", Constants.UPLOAD_HTTP_ERROR, 13566500);
        PSDNOA = new HwmfTernaryRasterOp("PSDNOA", 208, 13635082);
        PSDPXOXN = new HwmfTernaryRasterOp("PSDPXOXN", 209, 13698666);
        PDSNAX = new HwmfTernaryRasterOp("PDSNAX", 210, 13764357);
        SPDSOAXN = new HwmfTernaryRasterOp("SPDSOAXN", 211, 13830052);
        SSPXPDXAX = new HwmfTernaryRasterOp("SSPXPDXAX", 212, 13901176);
        DPSANAN = new HwmfTernaryRasterOp("DPSANAN", Constants.UPLOAD_DISASTER_DROP, 13962473);
        PSDPSAOXX = new HwmfTernaryRasterOp("PSDPSAOXX", Constants.UPLOAD_DISASTER_ESCAPE, 14030570);
        DPSXAN = new HwmfTernaryRasterOp("DPSXAN", 215, 14091081);
        PDSPXAX = new HwmfTernaryRasterOp("PDSPXAX", 216, 14157637);
        SDPSAOXN = new HwmfTernaryRasterOp("SDPSAOXN", 217, 14223080);
        DPSDANAX = new HwmfTernaryRasterOp("DPSDANAX", 218, 14294249);
        SPXDSXAN = new HwmfTernaryRasterOp("SPXDSXAN", 219, 14355829);
        SPDNAO = new HwmfTernaryRasterOp("SPDNAO", 220, 14420740);
        SDNO = new HwmfTernaryRasterOp("SDNO", 221, 14484008);
        SDPXO = new HwmfTernaryRasterOp("SDPXO", 222, 14549608);
        SDPANO = new HwmfTernaryRasterOp("SDPANO", 223, 14616776);
        PDSOA = new HwmfTernaryRasterOp("PDSOA", 224, 14680997);
        PDSOXN = new HwmfTernaryRasterOp("PDSOXN", 225, 14745989);
        DSPDXAX = new HwmfTernaryRasterOp("DSPDXAX", 226, 14812998);
        PSDPAOXN = new HwmfTernaryRasterOp("PSDPAOXN", 227, 14878442);
        SDPSXAX = new HwmfTernaryRasterOp("SDPSXAX", 228, 14944072);
        PDSPAOXN = new HwmfTernaryRasterOp("PDSPAOXN", 229, 15009509);
        SDPSANAX = new HwmfTernaryRasterOp("SDPSANAX", 230, 15080680);
        SPXPDXAN = new HwmfTernaryRasterOp("SPXPDXAN", 231, 15142265);
        SSPXDSXAX = new HwmfTernaryRasterOp("SSPXDSXAX", 232, 15211892);
        DSPDSANAXXN = new HwmfTernaryRasterOp("DSPDSANAXXN", 233, 15293670);
        DPSAO = new HwmfTernaryRasterOp("DPSAO", 234, 15336169);
        DPSXNO = new HwmfTernaryRasterOp("DPSXNO", 235, 15403081);
        SDPAO = new HwmfTernaryRasterOp("SDPAO", 236, 15467240);
        SDPXNO = new HwmfTernaryRasterOp("SDPXNO", 237, 15534152);
        SRCPAINT = new HwmfTernaryRasterOp("SRCPAINT", 238, 15597702);
        SDPNOO = new HwmfTernaryRasterOp("SDPNOO", 239, 15665672);
        PATCOPY = new HwmfTernaryRasterOp("PATCOPY", 240, 15728673);
        PDSONO = new HwmfTernaryRasterOp("PDSONO", 241, 15796357);
        PDSNAO = new HwmfTernaryRasterOp("PDSNAO", 242, 15862533);
        PSNO = new HwmfTernaryRasterOp("PSNO", 243, 15925802);
        PSDNAO = new HwmfTernaryRasterOp("PSDNAO", 244, 15993610);
        PDNO = new HwmfTernaryRasterOp("PDNO", 245, 16056869);
        PDSXO = new HwmfTernaryRasterOp("PDSXO", 246, 16122469);
        PDSANO = new HwmfTernaryRasterOp("PDSANO", 247, 16189637);
        PDSAO = new HwmfTernaryRasterOp("PDSAO", 248, 16253669);
        PDSXNO = new HwmfTernaryRasterOp("PDSXNO", 249, 16320581);
        DPO = new HwmfTernaryRasterOp("DPO", ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 16384137);
        PATPAINT = new HwmfTernaryRasterOp("PATPAINT", 251, 16452105);
        PSO = new HwmfTernaryRasterOp("PSO", 252, 16515210);
        PSDNOO = new HwmfTernaryRasterOp("PSDNOO", 253, 16583178);
        DPSOO = new HwmfTernaryRasterOp("DPSOO", 254, 16646825);
        WHITENESS = new HwmfTernaryRasterOp("WHITENESS", 255, 16711778);
        $VALUES = new HwmfTernaryRasterOp[]{BLACKNESS, DPSOON, DPSONA, PSON, SDPONA, DPON, PDSXNON, PDSAON, SDPNAA, PDSXON, DPNA, PSDNAON, SPNA, PDSNAON, PDSONON, PN, PDSONA, NOTSRCERASE, SDPXNON, SDPAON, DPSXNON, DPSAON, PSDPSANAXX, SSPXDSXAXN, SPXPDXA, SDPSANAXN, PDSPAOX, SDPSXAXN, PSDPAOX, DSPDXAXN, PDSOX, PDSOAN, DPSNAA, SDPXON, DSNA, SPDNAON, SPXDSXA, PDSPANAXN, SDPSAOX, SDPSXNOX, DPSXA, PSDPSAOXXN, DPSANA, SSPXPDXAXN, SPDSOAX, PSDNOX, PSDPXOX, PSDNOAN, PSNA, SDPNAON, SDPSOOX, NOTSRCCOPY, SPDSAOX, SPDSXNOX, SDPOX, SDPOAN, PSDPOAX, SPDNOX, SPDSXOX, SPDNOAN, PSX, SPDSONOX, SPDSNAOX, PSAN, PSDNAA, DPSXON, SDXPDXA, SPDSANAXN, SRCERASE, DPSNAON, DSPDAOX, PSDPXAXN, SDPXA, PDSPDAOXXN, DPSDOAX, PDSNOX, SDPANA, SSPXDSXOXN, PDSPXOX, PDSNOAN, PDNA, DSPNAON, DPSDAOX, SPDSXAXN, DPSONON, DSTINVERT, DPSOX, DPSOAN, PDSPOAX, DPSNOX, PATINVERT, DPSDONOX, DPSDXOX, DPSNOAN, DPSDNAOX, DPAN, PDSXA, DSPDSAOXXN, DSPDOAX, SDPNOX, SDPSOAX, DSPNOX, SRCINVERT, SDPSONOX, DSPDSONOXXN, PDSXXN, DPSAX, PSDPSOAXXN, SDPAX, PDSPDOAXXN, SDPSNOAX, PDSXNAN, PDSANA, SSDXPDXAXN, SDPSXOX, SDPNOAN, DSPDXOX, DSPNOAN, SDPSNAOX, DSAN, PDSAX, DSPDSOAXXN, DPSDNOAX, SDPXNAN, SPDSNOAX, DPSXNAN, SPXDSXO, DPSAAN, DPSAA, SPXDSXON, DPSXNA, SPDSNOAXN, SDPXNA, PDSPNOAXN, DSPDSOAXX, PDSAXN, SRCAND, SDPSNAOXN, DSPNOA, DSPDXOXN, SDPNOA, SDPSXOXN, SSDXPDXAX, PDSANAN, PDSXNA, SDPSNOAXN, DPSDPOAXX, SPDAXN, PSDPSOAXX, DPSAXN, DPSXX, PSDPSONOXX, SDPSONOXN, DSXN, DPSNAX, SDPSOAXN, SPDNAX, DSPDOAXN, DSPDSAOXX, PDSXAN, DPA, PDSPNAOXN, DPSNOA, DPSDXOXN, PDSPONOXN, PDXN, DSPNAX, PDSPOAXN, DPSOA, DPSOXN, D, DPSONO, SPDSXAX, DPSDAOXN, DSPNAO, DPNO, PDSNOA, PDSPXOXN, SSPXDSXOX, SDPANAN, PSDNAX, DPSDOAXN, DPSDPAOXX, SDPXAN, PSDPXAX, DSPDAOXN, DPSNAO, MERGEPAINT, SPDSANAX, SDXPDXAN, DPSXO, DPSANO, MERGECOPY, SPDSNAOXN, SPDSONOXN, PSXN, SPDNOA, SPDSXOXN, SDPNAX, PSDPOAXN, SDPOA, SPDOXN, DPSDXAX, SPDSAOXN, SRCCOPY, SDPONO, SDPNAO, SPNO, PSDNOA, PSDPXOXN, PDSNAX, SPDSOAXN, SSPXPDXAX, DPSANAN, PSDPSAOXX, DPSXAN, PDSPXAX, SDPSAOXN, DPSDANAX, SPXDSXAN, SPDNAO, SDNO, SDPXO, SDPANO, PDSOA, PDSOXN, DSPDXAX, PSDPAOXN, SDPSXAX, PDSPAOXN, SDPSANAX, SPXPDXAN, SSPXDSXAX, DSPDSANAXXN, DPSAO, DPSXNO, SDPAO, SDPXNO, SRCPAINT, SDPNOO, PATCOPY, PDSONO, PDSNAO, PSNO, PSDNAO, PDNO, PDSXO, PDSANO, PDSAO, PDSXNO, DPO, PATPAINT, PSO, PSDNOO, DPSOO, WHITENESS};
        ARG_ORDER = new String[]{"SSSSSS", "PPPPPP", "DDDDDD", null, "SPDSPD", "PDSPDS", "DSPDSP", null, "SDPSDP", "DPSDPS", "PSDPSD", null, null, null, null, null, null, null, null, null, "SSP.DS", "SP.DS", null, null, "SSP.PD", "SP.PD", null, null, "SSD.PD", "SD.PD", null, null};
    }

    private HwmfTernaryRasterOp(String r1, int r2, int r3) {
        super(r1, r2);
        this.opValue = r3;
    }

    private static int[] checkClone(int[] r0, int[] r1, int[] r2, int[] r3, boolean r4) {
        if (r4 == false) goto L8;
        if (r0 == r2) goto L7;
        if (r0 == r3) goto L7;
        if (r0 == r1) goto L7;
        return r0;
    L7:
        return (int[]) ZeusTransformUtils.preCheckCast(r0.clone(), int[].class, "com.obric.memorydata.plugin");
    L8:
        return r0;
    }

    private static void op0(Deque<int[]> r0, int[] r1, int[] r2, int[] r3) {
        Deque r4 = (Deque) ZeusTransformUtils.wrapperContextForParams(r0, Deque.class, "com.obric.memorydata.plugin");
        int[] r5 = new int[r1.length];
        Arrays.fill(r5, ViewCompat.MEASURED_STATE_MASK);
        r4.push(r5);
    }

    private static void op1(Deque<int[]> r0, int[] r1, int[] r2, int[] r3) {
        Deque r4 = (Deque) ZeusTransformUtils.wrapperContextForParams(r0, Deque.class, "com.obric.memorydata.plugin");
        int[] r5 = new int[r1.length];
        Arrays.fill(r5, -1);
        r4.push(r5);
    }

    private static void opA(Deque<int[]> r4, int[] r5, int[] r6, int[] r7) {
        Deque r8 = (Deque) ZeusTransformUtils.wrapperContextForParams(r4, Deque.class, "com.obric.memorydata.plugin");
        int[] r1 = checkClone((int[]) ZeusTransformUtils.preCheckCast(r8.pop(), int[].class, "com.obric.memorydata.plugin"), r5, r6, r7, true);
        int r2 = 0;
        int[] r9 = checkClone((int[]) ZeusTransformUtils.preCheckCast(r8.pop(), int[].class, "com.obric.memorydata.plugin"), r5, r6, r7, false);
    L4:
        if (r2 >= r1.length) goto L6;
        r1[r2] = (r1[r2] & ViewCompat.MEASURED_STATE_MASK) | ((r1[r2] & r9[r2]) & ViewCompat.MEASURED_SIZE_MASK);
        r2 = r2 + 1;
        goto L4
    L6:
        r8.push(r1);
    }

    private static void opD(Deque<int[]> r0, int[] r1, int[] r2, int[] r3) {
        ((Deque) ZeusTransformUtils.wrapperContextForParams(r0, Deque.class, "com.obric.memorydata.plugin")).push(r1);
    }

    private static void opN(Deque<int[]> r3, int[] r4, int[] r5, int[] r6) {
        Deque r7 = (Deque) ZeusTransformUtils.wrapperContextForParams(r3, Deque.class, "com.obric.memorydata.plugin");
        int[] r8 = checkClone((int[]) ZeusTransformUtils.preCheckCast(r7.pop(), int[].class, "com.obric.memorydata.plugin"), r4, r5, r6, true);
        int r9 = 0;
    L4:
        if (r9 >= r8.length) goto L6;
        r8[r9] = (r8[r9] & ViewCompat.MEASURED_STATE_MASK) | ((~r8[r9]) & ViewCompat.MEASURED_SIZE_MASK);
        r9 = r9 + 1;
        goto L4
    L6:
        r7.push(r8);
    }

    private static void opO(Deque<int[]> r4, int[] r5, int[] r6, int[] r7) {
        Deque r8 = (Deque) ZeusTransformUtils.wrapperContextForParams(r4, Deque.class, "com.obric.memorydata.plugin");
        int[] r1 = checkClone((int[]) ZeusTransformUtils.preCheckCast(r8.pop(), int[].class, "com.obric.memorydata.plugin"), r5, r6, r7, true);
        int r2 = 0;
        int[] r9 = checkClone((int[]) ZeusTransformUtils.preCheckCast(r8.pop(), int[].class, "com.obric.memorydata.plugin"), r5, r6, r7, false);
    L4:
        if (r2 >= r1.length) goto L6;
        r1[r2] = (r1[r2] & ViewCompat.MEASURED_STATE_MASK) | ((r1[r2] | r9[r2]) & ViewCompat.MEASURED_SIZE_MASK);
        r2 = r2 + 1;
        goto L4
    L6:
        r8.push(r1);
    }

    private static void opP(Deque<int[]> r0, int[] r1, int[] r2, int[] r3) {
        ((Deque) ZeusTransformUtils.wrapperContextForParams(r0, Deque.class, "com.obric.memorydata.plugin")).push(r3);
    }

    private static void opS(Deque<int[]> r0, int[] r1, int[] r2, int[] r3) {
        ((Deque) ZeusTransformUtils.wrapperContextForParams(r0, Deque.class, "com.obric.memorydata.plugin")).push(r2);
    }

    private static void opX(Deque<int[]> r4, int[] r5, int[] r6, int[] r7) {
        Deque r8 = (Deque) ZeusTransformUtils.wrapperContextForParams(r4, Deque.class, "com.obric.memorydata.plugin");
        int[] r1 = checkClone((int[]) ZeusTransformUtils.preCheckCast(r8.pop(), int[].class, "com.obric.memorydata.plugin"), r5, r6, r7, true);
        int r2 = 0;
        int[] r9 = checkClone((int[]) ZeusTransformUtils.preCheckCast(r8.pop(), int[].class, "com.obric.memorydata.plugin"), r5, r6, r7, false);
    L4:
        if (r2 >= r1.length) goto L6;
        r1[r2] = (r1[r2] & ViewCompat.MEASURED_STATE_MASK) | ((r1[r2] ^ r9[r2]) & ViewCompat.MEASURED_SIZE_MASK);
        r2 = r2 + 1;
        goto L4
    L6:
        r8.push(r1);
    }

    public static HwmfTernaryRasterOp valueOf(int r5) {
        HwmfTernaryRasterOp[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        HwmfTernaryRasterOp r3 = r0[r2];
        if (r3.getOpIndex() == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static HwmfTernaryRasterOp valueOf(String r2) {
        return (HwmfTernaryRasterOp) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfTernaryRasterOp.class, r2), HwmfTernaryRasterOp.class, "com.obric.memorydata.plugin");
    }

    public static HwmfTernaryRasterOp[] values() {
        return (HwmfTernaryRasterOp[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfTernaryRasterOp[].class, "com.obric.memorydata.plugin");
    }

    public String calcCmd() {
        String r0 = ARG_ORDER[this.opValue & 31];
        int[] r2 = new int[5];
        int r3 = 6;
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r5 >= 5) goto L8;
        int r7 = (this.opValue >>> r3) & 3;
        r2[r5] = r7;
        if (r7 == 0) goto L7;
        r6 = r5 + 1;
    L7:
        r5 = r5 + 1;
        r3 = r3 + 2;
        goto L3
    L8:
        StringBuilder r4 = new StringBuilder();
        StringBuilder r8 = new StringBuilder();
        r4.append(r0.charAt(0));
        int r9 = 0;
        int r10 = 1;
    L10:
        if (r9 >= r6) goto L20;
        char r11 = OPS.charAt(r2[r9]);
        char r12 = r0.charAt(r10);
        r8.append(r11);
        if (r12 != '.') goto L14;
        r4.insert(r10, r8.charAt(0));
        r8.deleteCharAt(0);
    L14:
        if (r11 == 'n') goto L19;
        if (r12 != '.') goto L18;
        r10 = r10 + 1;
        r12 = r0.charAt(r10);
    L18:
        r4.append(r12);
        r10 = r10 + 1;
    L19:
        r9 = r9 + 1;
        goto L10
    L20:
        r4.append(r8);
        if ((r6 % 2) != ((this.opValue >>> 5) & 1)) goto L23;
        r4.append('n');
    L23:
        String r15 = r4.toString();
        if (r15.startsWith("DDx") == true) goto L26;
        return r15;
    L26:
        if ("DDx".equals(r15) == false) goto L28;
        return "0";
    L28:
        return "1";
    }

    public String describeCmd() {
        String[] r0 = new String[10];
        char[] r8 = calcCmd().toCharArray();
        int r1 = r8.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L35;
        char r4 = r8[r2];
        if (r4 != '0') goto L7;
        int r5 = r3 + 1;
        r0[r3] = "all black";
    L32:
        r3 = r5;
    L33:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r4 != '1') goto L9;
        r5 = r3 + 1;
        r0[r3] = "all white";
        goto L32
    L9:
        if (r4 != 'D') goto L11;
    L29:
        r0[r3] = "" + r4;
        r3 = r3 + 1;
        goto L33
    L11:
        if (r4 == 'P') goto L29;
        if (r4 == 'S') goto L29;
        if (r4 != 'a') goto L17;
        int r6 = r3 - 2;
        r0[r6] = "(" + r0[r3 - 1] + " and " + r0[r6] + ")";
    L28:
        r3 = r3 - 1;
        goto L33
    L17:
        if (r4 != 'x') goto L19;
        int r7 = r3 - 2;
        r0[r7] = "(" + r0[r3 - 1] + " xor " + r0[r7] + ")";
        goto L28
    L19:
        if (r4 != 'n') goto L21;
        int r9 = r3 - 1;
        r0[r9] = "not(" + r0[r9] + ")";
        goto L33
    L21:
        if (r4 != 'o') goto L24;
        int r10 = r3 - 2;
        r0[r10] = "(" + r0[r3 - 1] + " or " + r0[r10] + ")";
        goto L28
    L24:
        throw new RuntimeException("unknown cmd '" + r4 + "'.");
    L35:
        return r0[r3 - 1];
    }

    public int getOpCode() {
        return this.opValue & 65535;
    }

    public int getOpIndex() {
        return this.opValue >>> 16;
    }

    public void process(Deque<int[]> r5, int[] r6, int[] r7, int[] r8) {
        Deque r9 = (Deque) ZeusTransformUtils.wrapperContextForParams(r5, Deque.class, "com.obric.memorydata.plugin");
        char[] r4 = calcCmd().toCharArray();
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L34;
        char r2 = r4[r1];
        if (r2 != '0') goto L7;
        op0(r9, r6, r7, r8);
    L33:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r2 != '1') goto L9;
        op1(r9, r6, r7, r8);
        goto L33
    L9:
        if (r2 != 'D') goto L11;
        opD(r9, r6, r7, r8);
        goto L33
    L11:
        if (r2 != 'P') goto L13;
        opP(r9, r6, r7, r8);
        goto L33
    L13:
        if (r2 != 'S') goto L15;
        opS(r9, r6, r7, r8);
        goto L33
    L15:
        if (r2 != 'a') goto L17;
        opA(r9, r6, r7, r8);
        goto L33
    L17:
        if (r2 != 'x') goto L19;
        opX(r9, r6, r7, r8);
        goto L33
    L19:
        if (r2 != 'n') goto L21;
        opN(r9, r6, r7, r8);
        goto L33
    L21:
        if (r2 != 'o') goto L24;
        opO(r9, r6, r7, r8);
        goto L33
    L24:
        throw new IllegalStateException();
    }
}
