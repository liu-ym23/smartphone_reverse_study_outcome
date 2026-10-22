package com.larus.audioplayer.api.news;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audioplayer/api/news/SOURCE_TYPE;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "URL", "VIDEO_MODEL", "LOCAL_FILE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum SOURCE_TYPE extends Enum<SOURCE_TYPE> {
    public static final SOURCE_TYPE LOCAL_FILE = null;
    public static final SOURCE_TYPE URL = null;
    public static final SOURCE_TYPE VIDEO_MODEL = null;
    public static final /* synthetic */ SOURCE_TYPE[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<SOURCE_TYPE> getEntries() {
        return b;
    }

    static {
        SOURCE_TYPE r0 = new SOURCE_TYPE("URL", 0, 0);
        URL = r0;
        SOURCE_TYPE r1 = new SOURCE_TYPE("VIDEO_MODEL", 1, 1);
        VIDEO_MODEL = r1;
        SOURCE_TYPE r3 = new SOURCE_TYPE("LOCAL_FILE", 2, 3);
        LOCAL_FILE = r3;
        SOURCE_TYPE[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static SOURCE_TYPE[] values() {
        return (SOURCE_TYPE[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SOURCE_TYPE valueOf(String r1) {
        return (SOURCE_TYPE) a.a(SOURCE_TYPE.class, r1);
    }

    public SOURCE_TYPE(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
