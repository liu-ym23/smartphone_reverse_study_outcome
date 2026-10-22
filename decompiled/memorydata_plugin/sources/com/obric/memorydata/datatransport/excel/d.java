package com.obric.memorydata.datatransport.excel;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.bu;
import com.obric.memorydata.datatransport.utils.f;
import com.obric.memorydata.datatransport.utils.g;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ab;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J(\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/datatransport/excel/ExcelProcessUtils;", "", "<init>", "()V", "TAG", "", "REQUEST_CODE_SELECT_FILE", "", "REQUEST_CODE_SELECT_XMEMORY_FILE", "REQUEST_CODE_SELECT_UPDATE_ORIGINAL_XMEMORY_FILE", "REQUEST_CODE_SELECT_XMEMORY_FILE_WITH_RESPONSE_AB", "REQUEST_CODE_SELECT_PERSONAL_CONTEXT_DATASET", "REQUEST_CODE_SELECT_PERSONAL_CONTEXT_ORIGINAL_DATASET", "exportDataToExcel", "", "excelMode", "Lcom/obric/memorydata/datatransport/excel/ExcelMode;", "importDataFromExcel", "context", "Landroid/content/Context;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "getPersonalContextEvaluationDataFromSelectedSheet", "", "Lcom/obric/memorydata/database/entity/EvaluationSourceDataEntity;", "sheet", "Lorg/apache/poi/ss/usermodel/Sheet;", "getPersonalContextOriginalDataFromSelectedSheet", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9750a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9751a = null;

        static {
            int[] r0 = new int[CellType.values().length];
            r0[CellType.NUMERIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CellType.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f9751a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/memorydata/datatransport/excel/ExcelProcessUtils$getPersonalContextEvaluationDataFromSelectedSheet$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/memorydata/datatransport/excel/ExcelProcessUtils$getPersonalContextOriginalDataFromSelectedSheet$11$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends Integer>> {
        c() {
        }
    }

    static {
        f9750a = new d();
    }

    private d() {
    }

    public static final /* synthetic */ List a(d r2, Sheet r3) {
        return r2.a((Sheet) ZeusTransformUtils.wrapperContextForParams(r3, Sheet.class, "com.obric.memorydata.plugin"));
    }

    private final List<bu> a(Sheet r64) {
        Sheet r0 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r64, Sheet.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        List<bu> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L110;
        int r4 = r0.getPhysicalNumberOfRows();
        int r6 = 0;
    L5:
        if (r6 >= r4) goto L110;
        Row r7 = r0.getRow(r6);
        if (r7 == null) goto L108;
        if (r6 != 0) goto L17;
        int r8 = r7.getPhysicalNumberOfCells();
        int r9 = 0;
    L10:
        if (r9 >= r8) goto L108;
        Cell r10 = r7.getCell(r9);
        if (r10 == null) goto L16;
        if (r10.getCellType() != CellType.STRING) goto L16;
        r2.put(r10.getStringCellValue(), Integer.valueOf(r9));
    L16:
        r9 = r9 + 1;
        goto L10
    L17:
        int r11 = r7.getFirstCellNum();
        short r12 = r7.getLastCellNum();
    L19:
        if (r11 >= r12) goto L29;
        Cell r13 = r7.getCell(r11, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
        if (r13 == null) goto L28;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13.toString(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L25;
        boolean r14 = true;
    L26:
        if (r14 == false) goto L28;
        boolean r15 = false;
    L30:
        if (r15 == true) goto L108;
        String r16 = "0";
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r2.get("session_type"), Integer.class, "com.obric.memorydata.plugin");
        String r18 = "";
        if (r17 == null) goto L37;
        Cell r19 = r7.getCell(((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r19 == null) goto L37;
        String r20 = r19.getStringCellValue();
        if (r20 == null) goto L37;
    L39:
        if (Intrinsics.areEqual(r20, SessionType.PERSONAL_CONTEXT_EVALUATION_DATA.getValue()) == false) goto L82;
        Integer r110 = (Integer) ZeusTransformUtils.preCheckCast(r2.get("type"), Integer.class, "com.obric.memorydata.plugin");
        if (r110 == null) goto L45;
        Cell r111 = r7.getCell(((Number) ZeusTransformUtils.preCheckCast(r110, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r111 == null) goto L45;
        int r112 = (int) r111.getNumericCellValue();
    L46:
        Integer r113 = (Integer) ZeusTransformUtils.preCheckCast(r2.get("evaluationId"), Integer.class, "com.obric.memorydata.plugin");
        if (r113 == null) goto L53;
        Cell r21 = r7.getCell(((Number) ZeusTransformUtils.preCheckCast(r113, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r21 == null) goto L52;
        r16 = r21.getStringCellValue();
        if (r16 != null) goto L53;
    L52:
        r16 = "";
    L53:
        Integer r114 = (Integer) ZeusTransformUtils.preCheckCast(r2.get("data"), Integer.class, "com.obric.memorydata.plugin");
        if (r114 == null) goto L59;
        Cell r115 = r7.getCell(((Number) ZeusTransformUtils.preCheckCast(r114, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r115 == null) goto L59;
        String r116 = r115.getStringCellValue();
        if (r116 == null) goto L59;
    L60:
        Integer r117 = (Integer) ZeusTransformUtils.preCheckCast(r2.get("createTime"), Integer.class, "com.obric.memorydata.plugin");
        if (r117 == null) goto L81;
        Cell r22 = r7.getCell(((Number) ZeusTransformUtils.preCheckCast(r117, Number.class, "com.obric.memorydata.plugin")).intValue());
        CellType r118 = r22.getCellType();
        if (r118 != null) goto L65;
        int r119 = -1;
    L66:
        Date r120 = null;
        if (r119 != 1) goto L69;
        r120 = DateUtil.getJavaDate(r22.getNumericCellValue());
    L77:
        if (r120 == null) goto L79;
        long r121 = r120.getTime();
    L80:
        String r23 = r16;
        String r122 = "";
        String r123 = r116;
        long r124 = r121;
        int r125 = r112;
    L107:
        r3.add(new bu(r124, r125, 0, r123, r122, 0, 0, r20, r23, null, null, null, null, 0, null, null, null, null, null, 0, null, 0, 4193892, null));
    L109:
        r6 = r6 + 1;
        r0 = r0;
        goto L5
    L79:
        r121 = 0;
        goto L80
    L69:
        if (r119 != 2) goto L77;
        String r24 = r22.getStringCellValue();
        Intrinsics.checkNotNull(r24);
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L74;
        SimpleDateFormat r5 = new SimpleDateFormat(f.f9839a.a());
    L75:
        r120 = r5.parse(r24);
        goto L77
    L74:
        r5 = new SimpleDateFormat(f.f9839a.b());
        goto L75
    L65:
        r119 = a.f9751a[r118.ordinal()];
        goto L66
    L81:
        r0 = r0;
        r23 = r16;
        r122 = "";
        r125 = r112;
        r123 = r116;
    L106:
        r124 = 0;
    L59:
        r116 = "";
    L45:
        r112 = 0;
        goto L46
    L82:
        r0 = r0;
        if (Intrinsics.areEqual(r20, SessionType.PERSONAL_CONTEXT_TEST_QUERY.getValue()) == false) goto L105;
        Integer r25 = (Integer) ZeusTransformUtils.preCheckCast(r2.get(TypedValues.AttributesType.S_TARGET), Integer.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L90;
        Cell r26 = r7.getCell(((Number) ZeusTransformUtils.preCheckCast(r25, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r26 == null) goto L90;
        String r27 = r26.getStringCellValue();
        if (r27 == null) goto L90;
    L91:
        Integer r126 = (Integer) ZeusTransformUtils.preCheckCast(r2.get(ChatMessage.TYPE_QUERY), Integer.class, "com.obric.memorydata.plugin");
        if (r126 == null) goto L99;
        Cell r127 = r7.getCell(((Number) ZeusTransformUtils.preCheckCast(r126, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r127 == null) goto L99;
        String r128 = r127.getStringCellValue();
        if (r128 == null) goto L99;
        r18 = r128;
    L99:
        Integer r129 = (Integer) ZeusTransformUtils.preCheckCast(r2.get(EventBody.KEY_CATEGORY), Integer.class, "com.obric.memorydata.plugin");
        if (r129 == null) goto L104;
        Cell r28 = r7.getCell(((Number) ZeusTransformUtils.preCheckCast(r129, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r28 == null) goto L104;
        r28.getStringCellValue();
    L104:
        Object r29 = ab.a().fromJson(r27, new b().getType());
        Intrinsics.checkNotNullExpressionValue(r29, "fromJson(...)");
        com.obric.memorydata.datatransport.excel.c.f9748a.insert(SessionType.EVALUATION_PERSONAL_CONTEXT_QUERY_RESULT, CollectionsKt.listOf(new com.obric.memorydata.datatransport.excel.b.g(null, null, new com.obric.memorydata.datatransport.excel.b.e(r18, (List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.memorydata.plugin"), null, 0.0d, 12, null), null, null, null, null, null, null, null, 0.0d, 0.0d, 0.0d, 0.0d, null, null, 65531, null)));
        r125 = 0;
        r122 = r27;
        r23 = "0";
        r123 = r18;
    L90:
        r27 = "";
        goto L91
    L105:
        r125 = 0;
        r23 = "0";
        r123 = "";
        r122 = r123;
    L37:
        r20 = "";
        goto L39
    L25:
        r14 = false;
    L28:
        r11 = r11 + 1;
        goto L19
    L29:
        r15 = true;
    L108:
        r0 = r0;
    L110:
        return r3;
    }

    public static final /* synthetic */ List b(d r2, Sheet r3) {
        return r2.b((Sheet) ZeusTransformUtils.wrapperContextForParams(r3, Sheet.class, "com.obric.memorydata.plugin"));
    }

    private final List<bu> b(Sheet r45) {
        Sheet r2 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r45, Sheet.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        List<bu> r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L220;
        int r6 = r2.getPhysicalNumberOfRows();
        int r8 = 0;
    L5:
        if (r8 >= r6) goto L220;
        Row r0 = r2.getRow(r8);
        if (r0 == null) goto L218;
        if (r8 != 0) goto L17;
        int r9 = r0.getPhysicalNumberOfCells();
        int r10 = 0;
    L10:
        if (r10 >= r9) goto L218;
        Cell r11 = r0.getCell(r10);
        if (r11 == null) goto L16;
        if (r11.getCellType() != CellType.STRING) goto L16;
        r3.put(r11.getStringCellValue(), Integer.valueOf(r10));
    L16:
        r10 = r10 + 1;
        goto L10
    L17:
        int r12 = r0.getFirstCellNum();
        short r13 = r0.getLastCellNum();
    L19:
        if (r12 >= r13) goto L29;
        Cell r14 = r0.getCell(r12, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
        if (r14 == null) goto L28;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14.toString(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L25;
        boolean r15 = true;
    L26:
        if (r15 == false) goto L28;
        boolean r16 = false;
    L30:
        if (r16 == true) goto L218;
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r3.get("数据类型"), Integer.class, "com.obric.memorydata.plugin");
        String r18 = "";
        if (r17 == null) goto L39;
        Cell r19 = r0.getCell(((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r19 == null) goto L37;
        String r110 = r19.getStringCellValue();
        if (r110 == null) goto L37;
    L38:
        Unit r111 = Unit.INSTANCE;
        Unit r112 = Unit.INSTANCE;
    L41:
        if (Intrinsics.areEqual(r110, SessionType.DATA.getValue()) == false) goto L188;
        Integer r113 = (Integer) ZeusTransformUtils.preCheckCast(r3.get("dataId"), Integer.class, "com.obric.memorydata.plugin");
        if (r113 == null) goto L48;
        Cell r114 = r0.getCell(((Number) ZeusTransformUtils.preCheckCast(r113, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r114 == null) goto L47;
        r114.getNumericCellValue();
    L47:
        Unit r115 = Unit.INSTANCE;
        Unit r116 = Unit.INSTANCE;
    L48:
        Integer r117 = (Integer) ZeusTransformUtils.preCheckCast(r3.get("Data"), Integer.class, "com.obric.memorydata.plugin");
        if (r117 == null) goto L56;
        Cell r118 = r0.getCell(((Number) ZeusTransformUtils.preCheckCast(r117, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r118 == null) goto L54;
        String r119 = r118.getStringCellValue();
        if (r119 == null) goto L54;
    L55:
        Unit r120 = Unit.INSTANCE;
        Unit r121 = Unit.INSTANCE;
    L57:
        Integer r122 = (Integer) ZeusTransformUtils.preCheckCast(r3.get("Type"), Integer.class, "com.obric.memorydata.plugin");
        if (r122 == null) goto L66;
        Cell r123 = r0.getCell(((Number) ZeusTransformUtils.preCheckCast(r122, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r123 == null) goto L65;
        String r124 = r123.getStringCellValue();
        if (r124 == null) goto L65;
        r18 = r124;
    L65:
        Unit r125 = Unit.INSTANCE;
        Unit r126 = Unit.INSTANCE;
    L66:
        Integer r127 = (Integer) ZeusTransformUtils.preCheckCast(r3.get("ID"), Integer.class, "com.obric.memorydata.plugin");
        String r128 = "0";
        if (r127 == null) goto L92;
        int r129 = ((Number) ZeusTransformUtils.preCheckCast(r127, Number.class, "com.obric.memorydata.plugin")).intValue();
        CellType r130 = r0.getCell(r129).getCellType();
        if (r130 != null) goto L71;
        int r131 = -1;
    L72:
        if (r131 != 1) goto L87;
        Cell r132 = r0.getCell(r129);
        int r23 = r8;
        if (r132 == null) goto L76;
        Integer r7 = Integer.valueOf((int) r132.getNumericCellValue());
    L77:
        String r20 = String.valueOf(r7);
        CharSequence r21 = (CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin");
        if (r21 != null) goto L80;
    L83:
        boolean r22 = true;
    L84:
        if (r22 == true) goto L91;
    L86:
        r128 = r20;
    L91:
        Unit r24 = Unit.INSTANCE;
        Unit r25 = Unit.INSTANCE;
    L93:
        String r26 = r128;
        Integer r27 = (Integer) ZeusTransformUtils.preCheckCast(r3.get("Time"), Integer.class, "com.obric.memorydata.plugin");
        if (r27 == null) goto L121;
        Cell r1 = r0.getCell(((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.memorydata.plugin")).intValue());
        CellType r28 = r1.getCellType();     // Catch: Exception -> L113
        if (r28 != null) goto L99;
        int r133 = -1;
    L100:
        if (r133 == 1) goto L108;
        if (r133 == 2) goto L103;
        Unit r29 = Unit.INSTANCE;     // Catch: Exception -> L113
        Date r30 = null;
    L116:
        Calendar r31 = Calendar.getInstance();
        r31.set(2024, 7, 1);
        long r134 = r31.getTimeInMillis();
        r31.add(1, -10);
        long r210 = r31.getTimeInMillis();
        if (r30 == null) goto L119;
        long r32 = r30.getTime();
    L120:
        Unit r33 = Unit.INSTANCE;
        Unit r34 = Unit.INSTANCE;
    L123:
        switch(r18.hashCode()) {
            case -1403156476: goto L151;
            case 664479: goto L146;
            case 719625: goto L142;
            case 972180: goto L138;
            case 975943: goto L134;
            case 32582771: goto L130;
            case 1134531560: goto L126;
            default: goto L156;
        };
    L156:
        int r135 = 0;
    L246:
        com.obric.memorydata.datatransport.a.a r35 = com.obric.memorydata.datatransport.a.a.f9716a.a(r119, Integer.valueOf(r135));     // Catch: Exception -> L165
        if (r35 == null) goto L163;
        AppEntity r36 = r35.d();     // Catch: Exception -> L165
        if (r36 == null) goto L163;
        r36.setId(r26);     // Catch: Exception -> L165
        r36.setLastModifiedTime(r32);     // Catch: Exception -> L165
        r36.setCreateTime(r32);     // Catch: Exception -> L165
    L167:
        if (r36 == null) goto L169;
        Integer r37 = Integer.valueOf(r36.getType());
    L170:
        if (r37 == null) goto L172;
        String r38 = r36.getType() + '_' + r36.getId();
    L176:
        r5.put(r26, r38);
        if (r36 == null) goto L179;
        com.obric.memorydata.datatransport.excel.c r39 = com.obric.memorydata.datatransport.excel.c.f9748a;
        SessionType r40 = SessionType.PERSONAL_CONTEXT_EVALUATION_DATA;
        com.obric.memorydata.datatransport.excel.b.h r136 = new com.obric.memorydata.datatransport.excel.b.h(r135, r32, 0, r36.toString(), g.f9841a.a(r135), null, null, r38, null, null, 868, null);
    L187:
        r39.insert(r40, CollectionsKt.listOf(r136));
        String.valueOf(r36);
    L219:
        r8 = r23 + 1;
        r2 = r2;
        r6 = r6;
        goto L5
    L179:
        if (r135 != 302) goto L185;
        if (StringsKt.startsWith$default(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r119, CharSequence.class, "com.obric.memorydata.plugin")).toString(), "{", false, 2, null) == true) goto L185;
        r119 = new AlbumEntity(r26, r32, r32, r119, null).toString();
    L185:
        r39 = com.obric.memorydata.datatransport.excel.c.f9748a;
        r40 = SessionType.PERSONAL_CONTEXT_EVALUATION_DATA;
        r136 = new com.obric.memorydata.datatransport.excel.b.h(r135, r32, 0, r119, g.f9841a.a(r135), null, null, r38, null, null, 868, null);
        goto L187
    L172:
        if (Intrinsics.areEqual(r18, "相簿") == false) goto L174;
        r38 = "302_" + r26;
        r135 = 302;
        goto L176
    L174:
        r38 = "301_" + r119;
        r135 = 301;
        goto L176
    L169:
        r37 = null;
    L163:
        r36 = null;
    L165:
        e = move-exception;
        RunLog.INSTANCE.debug("ExcelProcessUtils", "error getting app entity id:" + ((String) ZeusTransformUtils.preCheckCast(r26, String.class, "com.obric.memorydata.plugin")) + ", data: " + ((String) ZeusTransformUtils.preCheckCast(r119, String.class, "com.obric.memorydata.plugin")) + "\n " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
        r36 = null;
        goto L167
    L126:
        if (r18.equals("通话记录") == false) goto L156;
        int r41 = 202;
    L149:
        r135 = r41;
        goto L246
    L130:
        if (r18.equals("联系人") == false) goto L156;
        r41 = 201;
        goto L149
    L134:
        if (r18.equals("相簿") == false) goto L156;
        r135 = 302;
        goto L246
    L138:
        if (r18.equals("短信") == false) goto L156;
        r41 = 101;
        goto L149
    L142:
        if (r18.equals("图片") == false) goto L156;
        r135 = 301;
        goto L246
    L146:
        if (r18.equals("便签") == false) goto L156;
        r41 = 601;
        goto L149
    L151:
        if (r18.equals("联系人/通话记录") == false) goto L156;
        com.obric.memorydata.datatransport.a.a r42 = com.obric.memorydata.datatransport.a.a.C0468a.a(com.obric.memorydata.datatransport.a.a.f9716a, r119, null, 2, null);
        if (r42 == null) goto L156;
        r41 = r42.getType();
        goto L149
    L119:
        r32 = Random.Default.nextLong(r134 - r210) + r210;
        goto L120
    L103:
        String r43 = r1.getStringCellValue();     // Catch: Exception -> L113
        Intrinsics.checkNotNull(r43);     // Catch: Exception -> L113
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r43, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L106;
        SimpleDateFormat r44 = new SimpleDateFormat(f.f9839a.a());     // Catch: Exception -> L113
    L107:
        r30 = r44.parse(r43);     // Catch: Exception -> L113
    L254:
        Unit r46 = Unit.INSTANCE;     // Catch: Exception -> L111
    L111:
        e = e;
    L115:
        RunLog.INSTANCE.debug("ExcelProcessUtils", "error parsing date: " + ((String) ZeusTransformUtils.preCheckCast(r119, String.class, "com.obric.memorydata.plugin")) + ", " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
        goto L116
    L106:
        r44 = new SimpleDateFormat(f.f9839a.b());     // Catch: Exception -> L113
        goto L107
    L108:
        r30 = DateUtil.getJavaDate(r1.getNumericCellValue());     // Catch: Exception -> L113
        goto L254
    L99:
        r133 = a.f9751a[r28.ordinal()];     // Catch: Exception -> L113
    L113:
        e = e;
        r30 = null;
        goto L115
    L121:
        r32 = 0;
        goto L123
    L80:
        if (r21.length() == 0) goto L83;
        r22 = false;
        goto L84
    L76:
        r7 = null;
        goto L77
    L87:
        r23 = r8;
        Cell r47 = r0.getCell(r129);
        if (r47 == null) goto L91;
        r20 = r47.getStringCellValue();
        if (r20 != null) goto L86;
    L71:
        r131 = a.f9751a[r130.ordinal()];
        goto L72
    L92:
        r23 = r8;
    L54:
        r119 = "";
        goto L55
    L56:
        r119 = "";
        goto L57
    L188:
        r2 = r2;
        r6 = r6;
        r23 = r8;
        if (Intrinsics.areEqual(r110, SessionType.QUERY.getValue()) == false) goto L219;
        Integer r48 = (Integer) ZeusTransformUtils.preCheckCast(r3.get("Target"), Integer.class, "com.obric.memorydata.plugin");
        if (r48 == null) goto L198;
        Cell r49 = r0.getCell(((Number) ZeusTransformUtils.preCheckCast(r48, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r49 == null) goto L196;
        String r50 = r49.getStringCellValue();
        if (r50 == null) goto L196;
    L197:
        Unit r51 = Unit.INSTANCE;
        Unit r52 = Unit.INSTANCE;
        String r310 = r50;
    L199:
        Integer r53 = (Integer) ZeusTransformUtils.preCheckCast(r3.get("一级分类"), Integer.class, "com.obric.memorydata.plugin");
        if (r53 == null) goto L207;
        Cell r54 = r0.getCell(((Number) ZeusTransformUtils.preCheckCast(r53, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r54 == null) goto L205;
        String r55 = r54.getStringCellValue();
        if (r55 == null) goto L205;
    L206:
        Unit r56 = Unit.INSTANCE;
        Unit r57 = Unit.INSTANCE;
        String r311 = r55;
    L208:
        Integer r58 = (Integer) ZeusTransformUtils.preCheckCast(r3.get("Data"), Integer.class, "com.obric.memorydata.plugin");
        if (r58 == null) goto L217;
        Cell r59 = r0.getCell(((Number) ZeusTransformUtils.preCheckCast(r58, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r59 == null) goto L216;
        String r60 = r59.getStringCellValue();
        if (r60 == null) goto L216;
        r18 = r60;
    L216:
        Unit r61 = Unit.INSTANCE;
        Unit r62 = Unit.INSTANCE;
    L217:
        com.obric.memorydata.datatransport.excel.c.f9748a.insert(SessionType.PERSONAL_CONTEXT_TEST_QUERY, CollectionsKt.listOf(new com.obric.memorydata.datatransport.excel.b.h(0, 0, 0, null, null, null, r18, null, r310, r311, 191, null)));
    L205:
        r55 = "";
        goto L206
    L207:
        r311 = "";
    L196:
        r50 = "";
        goto L197
    L198:
        r310 = "";
    L37:
        r110 = "";
        goto L38
    L39:
        r110 = "";
        goto L41
    L25:
        r15 = false;
    L28:
        r12 = r12 + 1;
        goto L19
    L29:
        r16 = true;
    L218:
        r2 = r2;
        r6 = r6;
        r23 = r8;
    L220:
        RunLog.INSTANCE.debug("EvaluationUtils", "Current id to evaluation id map: " + r5);
        List<bu> r63 = com.obric.memorydata.datatransport.excel.c.f9748a.a().queryBySessionType(SessionType.PERSONAL_CONTEXT_TEST_QUERY.getValue());
        List r64 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r65 = ((Iterable) ZeusTransformUtils.preCheckCast(r63, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L222:
        if (r65.hasNext() == false) goto L230;
        com.obric.memorydata.datatransport.excel.b r66 = (com.obric.memorydata.datatransport.excel.b) ZeusTransformUtils.preCheckCast(ab.a().fromJson(((bu) ZeusTransformUtils.preCheckCast(r65.next(), bu.class, "com.obric.memorydata.plugin")).m(), com.obric.memorydata.datatransport.excel.b.h.class), com.obric.memorydata.datatransport.excel.b.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L228
        if (r66 == null) goto L222;
        Boolean.valueOf(r64.add(r66));     // Catch: Exception -> L228
    L228:
        e = move-exception;
        RunLog.INSTANCE.debug("ExcelUtils", "Fail to handle extra string: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
        goto L222
    L230:
        Iterator r67 = ((Iterable) ZeusTransformUtils.preCheckCast(r64, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L232:
        if (r67.hasNext() == false) goto L245;
        com.obric.memorydata.datatransport.excel.b.h r68 = (com.obric.memorydata.datatransport.excel.b.h) ZeusTransformUtils.preCheckCast(r67.next(), com.obric.memorydata.datatransport.excel.b.h.class, "com.obric.memorydata.plugin");
        Object r69 = ab.a().fromJson(r68.h(), new c().getType());     // Catch: Exception -> L243
        Intrinsics.checkNotNullExpressionValue(r69, "fromJson(...)");     // Catch: Exception -> L243
        Iterable r70 = (Iterable) ZeusTransformUtils.preCheckCast(r69, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L243
        Collection r71 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r70, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L243
        Iterator r72 = r70.iterator();     // Catch: Exception -> L243
    L236:
        if (r72.hasNext() == false) goto L241;
        String r73 = (String) ZeusTransformUtils.preCheckCast(r5.get(String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r72.next(), Number.class, "com.obric.memorydata.plugin")).intValue())), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L243
        if (r73 != null) goto L240;
        r73 = "UNKNOWN";
    L240:
        r71.add(r73);     // Catch: Exception -> L243
        goto L236
    L241:
        com.obric.memorydata.datatransport.excel.c.f9748a.update(SessionType.PERSONAL_CONTEXT_TEST_QUERY, (com.obric.memorydata.datatransport.excel.b) ZeusTransformUtils.preCheckCast(r68, com.obric.memorydata.datatransport.excel.b.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.datatransport.excel.b) ZeusTransformUtils.preCheckCast(com.obric.memorydata.datatransport.excel.b.h.a(r68, 0, 0, 0, null, null, null, null, null, u.a((List) ZeusTransformUtils.preCheckCast(r71, List.class, "com.obric.memorydata.plugin")), null, 767, null), com.obric.memorydata.datatransport.excel.b.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L243
    L243:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EvaluationUtils", "Error to parse target list:" + r68.h() + '\n' + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
        goto L232
    L245:
        return r4;
    }
}
