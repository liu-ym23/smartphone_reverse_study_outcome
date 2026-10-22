package com.lark.kmp.rustclient.api.model;

import com.lark.kmp.pb.basic.v1.RequestPacket;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/rustclient/api/model/StreamDataSource;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "DEFAULT_SMART", "ONCE_LOCAL", "ONCE_NET", "Companion", "rust-client_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum StreamDataSource extends Enum<StreamDataSource> {
    public static final a Companion = null;
    public static final StreamDataSource DEFAULT_SMART = null;
    public static final StreamDataSource ONCE_LOCAL = null;
    public static final StreamDataSource ONCE_NET = null;
    public static final /* synthetic */ StreamDataSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int number;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<StreamDataSource> getEntries() {
        return b;
    }

    static {
        StreamDataSource r0 = new StreamDataSource("DEFAULT_SMART", 0, 1);
        DEFAULT_SMART = r0;
        StreamDataSource r1 = new StreamDataSource("ONCE_LOCAL", 1, 2);
        ONCE_LOCAL = r1;
        StreamDataSource r4 = new StreamDataSource("ONCE_NET", 2, 3);
        ONCE_NET = r4;
        StreamDataSource[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
        Companion = new a();
    }

    public static StreamDataSource[] values() {
        return (StreamDataSource[]) a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    @JvmStatic
    public static final RequestPacket.BizConfig.DataSource forNumber(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L14;
        return RequestPacket.BizConfig.DataSource.DEFAULT;
    L14:
        return RequestPacket.BizConfig.DataSource.PREFERRED_ONLINE;
    L15:
        return RequestPacket.BizConfig.DataSource.LOCAL;
    L12:
        return RequestPacket.BizConfig.DataSource.DEFAULT;
    }

    @JvmStatic
    public static final StreamDataSource valueOf(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L14;
        return DEFAULT_SMART;
    L14:
        return ONCE_NET;
    L15:
        return ONCE_LOCAL;
    L12:
        return DEFAULT_SMART;
    }

    public static StreamDataSource valueOf(String r1) {
        return (StreamDataSource) r27.a.a(StreamDataSource.class, r1);
    }

    public StreamDataSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.number = r3;
    }
}
