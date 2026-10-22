package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.profileinstaller.ProfileVerifier;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b^\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u009f\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001fJ\u000b\u0010Y\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010[\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010`\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010i\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010j\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010l\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010=J\u000b\u0010m\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0004HÆ\u0003J¨\u0002\u0010p\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010qJ\t\u0010r\u001a\u00020\u0007HÖ\u0001J\u0013\u0010s\u001a\u00020\u000b2\b\u0010t\u001a\u0004\u0018\u00010uHÖ\u0003J\t\u0010v\u001a\u00020\u0007HÖ\u0001J\b\u0010w\u001a\u00020\u000bH\u0016J\u0012\u0010x\u001a\u00020\u00012\b\u0010y\u001a\u0004\u0018\u00010uH\u0016J\t\u0010z\u001a\u00020\u0004HÖ\u0001J\u0019\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010!\"\u0004\b*\u0010#R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010!\"\u0004\b.\u0010#R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010!\"\u0004\b0\u0010#R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b3\u0010%\"\u0004\b4\u0010'R$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010!\"\u0004\b;\u0010#R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010!\"\u0004\bB\u0010#R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010!\"\u0004\bD\u0010#R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010!\"\u0004\bF\u0010#R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010!\"\u0004\bH\u0010#R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\bI\u0010%\"\u0004\bJ\u0010'R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010!\"\u0004\bL\u0010#R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010!\"\u0004\bN\u0010#R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010!\"\u0004\bP\u0010#R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010!\"\u0004\bR\u0010#R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\bS\u0010%\"\u0004\bT\u0010'R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010!\"\u0004\bV\u0010#R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\bW\u0010%\"\u0004\bX\u0010'¨\u0006\u0080\u0001"}, d2 = {"Lcom/obric/capabilitykit/common/intent/BrowserUseParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "action", "", "version", "amount", "", "direction", "index", "new_tab", "", "query", "schema_hint", "script", "seconds", "selector", "task", "engine", "url", "inputs", "", "Lcom/obric/capabilitykit/common/intent/BrowserUseInput;", "x", "xpath", "y", "file_name", "content_disposition", "mime_type", "referer", "headers", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/BrowserUseInput;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getAmount", "()Ljava/lang/Integer;", "setAmount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContent_disposition", "setContent_disposition", "getDirection", "setDirection", "getEngine", "setEngine", "getFile_name", "setFile_name", "getHeaders", "setHeaders", "getIndex", "setIndex", "getInputs", "()[Lcom/obric/capabilitykit/common/intent/BrowserUseInput;", "setInputs", "([Lcom/obric/capabilitykit/common/intent/BrowserUseInput;)V", "[Lcom/obric/capabilitykit/common/intent/BrowserUseInput;", "getMime_type", "setMime_type", "getNew_tab", "()Ljava/lang/Boolean;", "setNew_tab", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getQuery", "setQuery", "getReferer", "setReferer", "getSchema_hint", "setSchema_hint", "getScript", "setScript", "getSeconds", "setSeconds", "getSelector", "setSelector", "getTask", "setTask", "getUrl", "setUrl", "getVersion", "setVersion", "getX", "setX", "getXpath", "setXpath", "getY", "setY", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/BrowserUseInput;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/BrowserUseParams;", "describeContents", "equals", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class BrowserUseParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<BrowserUseParams> CREATOR = null;
    private String action;
    private Integer amount;
    private String content_disposition;
    private String direction;
    private String engine;
    private String file_name;
    private String headers;
    private Integer index;
    private BrowserUseInput[] inputs;
    private String mime_type;
    private Boolean new_tab;
    private String query;
    private String referer;
    private String schema_hint;
    private String script;
    private Integer seconds;
    private String selector;
    private String task;
    private String url;
    private String version;
    private Integer x;
    private String xpath;
    private Integer y;

    static {
        CREATOR = new a();
    }

    public BrowserUseParams() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
    }

    public static /* synthetic */ BrowserUseParams copy$default(BrowserUseParams r17, String r18, String r19, Integer r20, String r21, Integer r22, Boolean r23, String r24, String r25, String r26, Integer r27, String r28, String r29, String r30, String r31, BrowserUseInput[] r32, Integer r33, String r34, Integer r35, String r36, String r37, String r38, String r39, String r40, int r41, Object r42) {
        if ((r41 & 1) == 0) goto L5;
        String r2 = r17.action;
    L7:
        if ((r41 & 2) == 0) goto L9;
        String r3 = r17.version;
    L11:
        if ((r41 & 4) == 0) goto L13;
        Integer r4 = r17.amount;
    L15:
        if ((r41 & 8) == 0) goto L17;
        String r5 = r17.direction;
    L19:
        if ((r41 & 16) == 0) goto L21;
        Integer r6 = r17.index;
    L23:
        if ((r41 & 32) == 0) goto L25;
        Boolean r7 = r17.new_tab;
    L27:
        if ((r41 & 64) == 0) goto L29;
        String r8 = r17.query;
    L31:
        if ((r41 & 128) == 0) goto L33;
        String r9 = r17.schema_hint;
    L35:
        if ((r41 & ISmModel.VERSION_0100) == 0) goto L37;
        String r10 = r17.script;
    L39:
        if ((r41 & ISmModel.VERSION_0200) == 0) goto L41;
        Integer r11 = r17.seconds;
    L43:
        if ((r41 & ISmModel.VERSION_0400) == 0) goto L45;
        String r12 = r17.selector;
    L47:
        if ((r41 & 2048) == 0) goto L49;
        String r13 = r17.task;
    L51:
        if ((r41 & 4096) == 0) goto L53;
        String r14 = r17.engine;
    L55:
        if ((r41 & 8192) == 0) goto L57;
        String r15 = r17.url;
    L58:
        String r310 = r15;
        if ((r41 & 16384) == 0) goto L61;
        BrowserUseInput[] r16 = r17.inputs;
    L62:
        BrowserUseInput[] r311 = r16;
        if ((r41 & 32768) == 0) goto L65;
        Integer r110 = r17.x;
    L66:
        Integer r312 = r110;
        if ((r41 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) == 0) goto L69;
        String r111 = r17.xpath;
    L70:
        String r313 = r111;
        if ((r41 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ) == 0) goto L73;
        Integer r112 = r17.y;
    L74:
        Integer r314 = r112;
        if ((r41 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION) == 0) goto L77;
        String r113 = r17.file_name;
    L78:
        String r315 = r113;
        if ((r41 & 524288) == 0) goto L81;
        String r114 = r17.content_disposition;
    L82:
        String r316 = r114;
        if ((r41 & 1048576) == 0) goto L85;
        String r115 = r17.mime_type;
    L86:
        String r317 = r115;
        if ((r41 & 2097152) == 0) goto L89;
        String r116 = r17.referer;
    L91:
        if ((r41 & 4194304) == 0) goto L93;
        String r1 = r17.headers;
    L95:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r116, r1);
    L93:
        r1 = r40;
        goto L95
    L89:
        r116 = r39;
        goto L91
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.action;
    }

    public final Integer component10() {
        return this.seconds;
    }

    public final String component11() {
        return this.selector;
    }

    public final String component12() {
        return this.task;
    }

    public final String component13() {
        return this.engine;
    }

    public final String component14() {
        return this.url;
    }

    public final BrowserUseInput[] component15() {
        return this.inputs;
    }

    public final Integer component16() {
        return this.x;
    }

    public final String component17() {
        return this.xpath;
    }

    public final Integer component18() {
        return this.y;
    }

    public final String component19() {
        return this.file_name;
    }

    public final String component2() {
        return this.version;
    }

    public final String component20() {
        return this.content_disposition;
    }

    public final String component21() {
        return this.mime_type;
    }

    public final String component22() {
        return this.referer;
    }

    public final String component23() {
        return this.headers;
    }

    public final Integer component3() {
        return this.amount;
    }

    public final String component4() {
        return this.direction;
    }

    public final Integer component5() {
        return this.index;
    }

    public final Boolean component6() {
        return this.new_tab;
    }

    public final String component7() {
        return this.query;
    }

    public final String component8() {
        return this.schema_hint;
    }

    public final String component9() {
        return this.script;
    }

    public final BrowserUseParams copy(String r26, String r27, Integer r28, String r29, Integer r30, Boolean r31, String r32, String r33, String r34, Integer r35, String r36, String r37, String r38, String r39, BrowserUseInput[] r40, Integer r41, String r42, Integer r43, String r44, String r45, String r46, String r47, String r48) {
        return new BrowserUseParams(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BrowserUseParams) == true) goto L8;
        return false;
    L8:
        BrowserUseParams r6 = (BrowserUseParams) r5;
        if (Intrinsics.areEqual(this.action, r6.action) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.amount, r6.amount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.direction, r6.direction) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.index, r6.index) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.new_tab, r6.new_tab) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.schema_hint, r6.schema_hint) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.script, r6.script) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.seconds, r6.seconds) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.selector, r6.selector) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.task, r6.task) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.engine, r6.engine) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.inputs, r6.inputs) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.x, r6.x) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.xpath, r6.xpath) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.y, r6.y) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.file_name, r6.file_name) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.content_disposition, r6.content_disposition) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.mime_type, r6.mime_type) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.referer, r6.referer) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.headers, r6.headers) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r0 = this.action;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.version;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.amount;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.direction;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.index;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.new_tab;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.query;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.schema_hint;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.script;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.seconds;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.selector;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.task;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.engine;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.url;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        BrowserUseInput[] r43 = this.inputs;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Integer r46 = this.x;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.xpath;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        Integer r52 = this.y;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        String r55 = this.file_name;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        String r58 = this.content_disposition;
        if (r58 != null) goto L81;
        int r59 = 0;
    L82:
        int r60 = (r57 + r59) * 31;
        String r61 = this.mime_type;
        if (r61 != null) goto L85;
        int r62 = 0;
    L86:
        int r63 = (r60 + r62) * 31;
        String r64 = this.referer;
        if (r64 != null) goto L89;
        int r65 = 0;
    L90:
        int r66 = (r63 + r65) * 31;
        String r67 = this.headers;
        if (r67 == null) goto L95;
        r1 = r67.hashCode();
    L95:
        return r66 + r1;
    L89:
        r65 = r64.hashCode();
        goto L90
    L85:
        r62 = r61.hashCode();
        goto L86
    L81:
        r59 = r58.hashCode();
        goto L82
    L77:
        r56 = r55.hashCode();
        goto L78
    L73:
        r53 = r52.hashCode();
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = Arrays.hashCode(r43);
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BrowserUseParams(action=" + this.action + ", version=" + this.version + ", amount=" + this.amount + ", direction=" + this.direction + ", index=" + this.index + ", new_tab=" + this.new_tab + ", query=" + this.query + ", schema_hint=" + this.schema_hint + ", script=" + this.script + ", seconds=" + this.seconds + ", selector=" + this.selector + ", task=" + this.task + ", engine=" + this.engine + ", url=" + this.url + ", inputs=" + Arrays.toString(this.inputs) + ", x=" + this.x + ", xpath=" + this.xpath + ", y=" + this.y + ", file_name=" + this.file_name + ", content_disposition=" + this.content_disposition + ", mime_type=" + this.mime_type + ", referer=" + this.referer + ", headers=" + this.headers + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r7, int r8) {
        r7.writeInt(0);
        Intrinsics.checkNotNullParameter(r7, "out");
        r7.writeString(this.action);
        r7.writeString(this.version);
        Integer r1 = this.amount;
        if (r1 != null) goto L5;
        r7.writeInt(0);
    L6:
        r7.writeString(this.direction);
        Integer r2 = this.index;
        if (r2 != null) goto L9;
        r7.writeInt(0);
    L10:
        Boolean r3 = this.new_tab;
        if (r3 != null) goto L13;
        r7.writeInt(0);
    L14:
        r7.writeString(this.query);
        r7.writeString(this.schema_hint);
        r7.writeString(this.script);
        Integer r4 = this.seconds;
        if (r4 != null) goto L17;
        r7.writeInt(0);
    L18:
        r7.writeString(this.selector);
        r7.writeString(this.task);
        r7.writeString(this.engine);
        r7.writeString(this.url);
        BrowserUseInput[] r5 = this.inputs;
        if (r5 != null) goto L21;
        r7.writeInt(0);
    L24:
        Integer r9 = this.x;
        if (r9 != null) goto L27;
        r7.writeInt(0);
    L28:
        r7.writeString(this.xpath);
        Integer r10 = this.y;
        if (r10 != null) goto L31;
        r7.writeInt(0);
    L32:
        r7.writeString(this.file_name);
        r7.writeString(this.content_disposition);
        r7.writeString(this.mime_type);
        r7.writeString(this.referer);
        r7.writeString(this.headers);
        return;
    L31:
        r7.writeInt(1);
        r7.writeInt(r10.intValue());
        goto L32
    L27:
        r7.writeInt(1);
        r7.writeInt(r9.intValue());
        goto L28
    L21:
        r7.writeInt(1);
        int r6 = r5.length;
        r7.writeInt(r6);
        int r11 = 0;
    L22:
        if (r11 == r6) goto L24;
        r5[r11].writeToParcel(r7, r8);
        r11 = r11 + 1;
        goto L22
    L17:
        r7.writeInt(1);
        r7.writeInt(r4.intValue());
        goto L18
    L13:
        r7.writeInt(1);
        r7.writeInt(r3.booleanValue() ? 1 : 0);
        goto L14
    L9:
        r7.writeInt(1);
        r7.writeInt(r2.intValue());
        goto L10
    L5:
        r7.writeInt(1);
        r7.writeInt(r1.intValue());
        goto L6
    }

    public boolean isParamsCompleted() {
        if (this.action == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getAction() {
        return this.action;
    }

    public final Integer getAmount() {
        return this.amount;
    }

    public final String getContent_disposition() {
        return this.content_disposition;
    }

    public final String getDirection() {
        return this.direction;
    }

    public final String getEngine() {
        return this.engine;
    }

    public final String getFile_name() {
        return this.file_name;
    }

    public final String getHeaders() {
        return this.headers;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final BrowserUseInput[] getInputs() {
        return this.inputs;
    }

    public final String getMime_type() {
        return this.mime_type;
    }

    public final Boolean getNew_tab() {
        return this.new_tab;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getReferer() {
        return this.referer;
    }

    public final String getSchema_hint() {
        return this.schema_hint;
    }

    public final String getScript() {
        return this.script;
    }

    public final Integer getSeconds() {
        return this.seconds;
    }

    public final String getSelector() {
        return this.selector;
    }

    public final String getTask() {
        return this.task;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVersion() {
        return this.version;
    }

    public final Integer getX() {
        return this.x;
    }

    public final String getXpath() {
        return this.xpath;
    }

    public final Integer getY() {
        return this.y;
    }

    public IntentParams mergeParams(Object r28) {
        if ((r28 instanceof BrowserUseParams) == true) goto L5;
        return this;
    L5:
        String r2 = this.action;
        if (r2 != null) goto L8;
        r2 = ((BrowserUseParams) r28).action;
    L8:
        String r4 = r2;
        String r3 = this.version;
        if (r3 != null) goto L11;
        r3 = ((BrowserUseParams) r28).version;
    L11:
        String r5 = r3;
        Integer r6 = this.amount;
        if (r6 != null) goto L14;
        r6 = ((BrowserUseParams) r28).amount;
    L14:
        Integer r7 = r6;
        String r8 = this.direction;
        if (r8 != null) goto L17;
        r8 = ((BrowserUseParams) r28).direction;
    L17:
        String r9 = r8;
        Integer r10 = this.index;
        if (r10 != null) goto L20;
        r10 = ((BrowserUseParams) r28).index;
    L20:
        Integer r11 = r10;
        Boolean r12 = this.new_tab;
        if (r12 != null) goto L23;
        r12 = ((BrowserUseParams) r28).new_tab;
    L23:
        Boolean r13 = r12;
        String r14 = this.query;
        if (r14 != null) goto L26;
        r14 = ((BrowserUseParams) r28).query;
    L26:
        String r15 = r14;
        String r16 = this.schema_hint;
        if (r16 != null) goto L29;
        r16 = ((BrowserUseParams) r28).schema_hint;
    L29:
        String r17 = r16;
        String r18 = this.script;
        if (r18 != null) goto L32;
        r18 = ((BrowserUseParams) r28).script;
    L32:
        String r19 = r18;
        Integer r20 = this.seconds;
        if (r20 != null) goto L35;
        r20 = ((BrowserUseParams) r28).seconds;
    L35:
        Integer r110 = r20;
        String r21 = this.selector;
        if (r21 != null) goto L38;
        r21 = ((BrowserUseParams) r28).selector;
    L38:
        String r111 = r21;
        String r22 = this.task;
        if (r22 != null) goto L41;
        r22 = ((BrowserUseParams) r28).task;
    L41:
        String r112 = r22;
        String r23 = this.engine;
        if (r23 != null) goto L44;
        r23 = ((BrowserUseParams) r28).engine;
    L44:
        String r113 = r23;
        String r24 = this.url;
        if (r24 != null) goto L47;
        r24 = ((BrowserUseParams) r28).url;
    L47:
        String r114 = r24;
        BrowserUseInput[] r25 = this.inputs;
        if (r25 != null) goto L50;
        r25 = ((BrowserUseParams) r28).inputs;
    L50:
        BrowserUseInput[] r115 = r25;
        Integer r26 = this.x;
        if (r26 != null) goto L53;
        r26 = ((BrowserUseParams) r28).x;
    L53:
        Integer r116 = r26;
        String r27 = this.xpath;
        if (r27 != null) goto L56;
        r27 = ((BrowserUseParams) r28).xpath;
    L56:
        String r29 = r27;
        Integer r30 = this.y;
        if (r30 != null) goto L59;
        r30 = ((BrowserUseParams) r28).y;
    L59:
        Integer r210 = r30;
        String r31 = this.file_name;
        if (r31 != null) goto L62;
        r31 = ((BrowserUseParams) r28).file_name;
    L62:
        String r211 = r31;
        String r32 = this.content_disposition;
        if (r32 != null) goto L65;
        r32 = ((BrowserUseParams) r28).content_disposition;
    L65:
        String r212 = r32;
        String r33 = this.mime_type;
        if (r33 != null) goto L68;
        r33 = ((BrowserUseParams) r28).mime_type;
    L68:
        String r213 = r33;
        String r34 = this.referer;
        if (r34 != null) goto L71;
        r34 = ((BrowserUseParams) r28).referer;
    L71:
        String r214 = r34;
        String r35 = this.headers;
        if (r35 != null) goto L74;
        String r215 = ((BrowserUseParams) r28).headers;
    L76:
        return new BrowserUseParams(r4, r5, r7, r9, r11, r13, r15, r17, r19, r110, r111, r112, r113, r114, r115, r116, r29, r210, r211, r212, r213, r214, r215);
    L74:
        r215 = r35;
        goto L76
    }

    public final void setAction(String r1) {
        this.action = r1;
    }

    public final void setAmount(Integer r1) {
        this.amount = r1;
    }

    public final void setContent_disposition(String r1) {
        this.content_disposition = r1;
    }

    public final void setDirection(String r1) {
        this.direction = r1;
    }

    public final void setEngine(String r1) {
        this.engine = r1;
    }

    public final void setFile_name(String r1) {
        this.file_name = r1;
    }

    public final void setHeaders(String r1) {
        this.headers = r1;
    }

    public final void setIndex(Integer r1) {
        this.index = r1;
    }

    public final void setInputs(BrowserUseInput[] r1) {
        this.inputs = r1;
    }

    public final void setMime_type(String r1) {
        this.mime_type = r1;
    }

    public final void setNew_tab(Boolean r1) {
        this.new_tab = r1;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    public final void setReferer(String r1) {
        this.referer = r1;
    }

    public final void setSchema_hint(String r1) {
        this.schema_hint = r1;
    }

    public final void setScript(String r1) {
        this.script = r1;
    }

    public final void setSeconds(Integer r1) {
        this.seconds = r1;
    }

    public final void setSelector(String r1) {
        this.selector = r1;
    }

    public final void setTask(String r1) {
        this.task = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public final void setVersion(String r1) {
        this.version = r1;
    }

    public final void setX(Integer r1) {
        this.x = r1;
    }

    public final void setXpath(String r1) {
        this.xpath = r1;
    }

    public final void setY(Integer r1) {
        this.y = r1;
    }

    public BrowserUseParams(String r3, String r4, Integer r5, String r6, Integer r7, Boolean r8, String r9, String r10, String r11, Integer r12, String r13, String r14, String r15, String r16, BrowserUseInput[] r17, Integer r18, String r19, Integer r20, String r21, String r22, String r23, String r24, String r25) {
        this.action = r3;
        this.version = r4;
        this.amount = r5;
        this.direction = r6;
        this.index = r7;
        this.new_tab = r8;
        this.query = r9;
        this.schema_hint = r10;
        this.script = r11;
        this.seconds = r12;
        this.selector = r13;
        this.task = r14;
        this.engine = r15;
        this.url = r16;
        this.inputs = r17;
        this.x = r18;
        this.xpath = r19;
        this.y = r20;
        this.file_name = r21;
        this.content_disposition = r22;
        this.mime_type = r23;
        this.referer = r24;
        this.headers = r25;
    }

    public /* synthetic */ BrowserUseParams(String r25, String r26, Integer r27, String r28, Integer r29, Boolean r30, String r31, String r32, String r33, Integer r34, String r35, String r36, String r37, String r38, BrowserUseInput[] r39, Integer r40, String r41, Integer r42, String r43, String r44, String r45, String r46, String r47, int r48, DefaultConstructorMarker r49) {
        if ((r48 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r48 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r48 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r48 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r48 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r48 & 32) == 0) goto L25;
        Boolean r7 = null;
    L27:
        if ((r48 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r48 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r48 & ISmModel.VERSION_0100) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r48 & ISmModel.VERSION_0200) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r48 & ISmModel.VERSION_0400) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r48 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r48 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r48 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r48 & 16384) == 0) goto L61;
        BrowserUseInput[] r2 = null;
    L63:
        if ((r48 & 32768) == 0) goto L65;
        Integer r16 = null;
    L67:
        if ((r48 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r48 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ) == 0) goto L73;
        Integer r18 = null;
    L75:
        if ((r48 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION) == 0) goto L77;
        String r19 = null;
    L79:
        if ((r48 & 524288) == 0) goto L81;
        String r20 = null;
    L83:
        if ((r48 & 1048576) == 0) goto L85;
        String r21 = null;
    L87:
        if ((r48 & 2097152) == 0) goto L89;
        String r22 = null;
    L91:
        if ((r48 & 4194304) == 0) goto L93;
        String r0 = null;
    L94:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r21, r22, r0);
        return;
    L93:
        r0 = r47;
        goto L94
    L89:
        r22 = r46;
        goto L91
    L85:
        r21 = r45;
        goto L87
    L81:
        r20 = r44;
        goto L83
    L77:
        r19 = r43;
        goto L79
    L73:
        r18 = r42;
        goto L75
    L69:
        r17 = r41;
        goto L71
    L65:
        r16 = r40;
        goto L67
    L61:
        r2 = r39;
        goto L63
    L57:
        r15 = r38;
        goto L59
    L53:
        r14 = r37;
        goto L55
    L49:
        r13 = r36;
        goto L51
    L45:
        r12 = r35;
        goto L47
    L41:
        r11 = r34;
        goto L43
    L37:
        r10 = r33;
        goto L39
    L33:
        r9 = r32;
        goto L35
    L29:
        r8 = r31;
        goto L31
    L25:
        r7 = r30;
        goto L27
    L21:
        r6 = r29;
        goto L23
    L17:
        r5 = r28;
        goto L19
    L13:
        r4 = r27;
        goto L15
    L9:
        r3 = r26;
        goto L11
    L5:
        r1 = r25;
        goto L7
    }
}
