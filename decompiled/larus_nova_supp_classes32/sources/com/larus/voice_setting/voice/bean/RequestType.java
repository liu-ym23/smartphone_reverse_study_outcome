package com.larus.voice_setting.voice.bean;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/voice_setting/voice/bean/RequestType;", NameKeys.UnloadStrategy_No_Strategy, "type", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "INIT", "LOAD_MORE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RequestType extends Enum<RequestType> {
    public static final RequestType INIT = null;
    public static final RequestType LOAD_MORE = null;
    public static final /* synthetic */ RequestType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private String type;

    public static EnumEntries<RequestType> getEntries() {
        return b;
    }

    static {
        RequestType r0 = new RequestType("INIT", 0, "init");
        INIT = r0;
        RequestType r1 = new RequestType("LOAD_MORE", 1, "load_more");
        LOAD_MORE = r1;
        RequestType[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static RequestType[] values() {
        return (RequestType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static RequestType valueOf(String r1) {
        return (RequestType) a.a(RequestType.class, r1);
    }

    public final void setType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.type = r2;
    }

    public RequestType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
