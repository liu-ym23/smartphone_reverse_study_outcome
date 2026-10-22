package com.bytedance.android.live.revenue.platform.network.api.dsl;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/dsl/ContentType;", "", "APPLICATION_JSON", "FORM_URL_ENCODED", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ContentType extends Enum<ContentType> {
    public static final ContentType APPLICATION_JSON = null;
    public static final ContentType FORM_URL_ENCODED = null;
    public static final /* synthetic */ ContentType[] a = null;

    static {
        ContentType r1 = new ContentType("APPLICATION_JSON", 0);
        APPLICATION_JSON = r1;
        ContentType r2 = new ContentType("FORM_URL_ENCODED", 1);
        FORM_URL_ENCODED = r2;
        a = new ContentType[]{r1, r2};
    }

    public static ContentType valueOf(String r1) {
        return (ContentType) a.a(ContentType.class, r1);
    }

    public static ContentType[] values() {
        return (ContentType[]) a.clone();
    }

    public ContentType(String r1, int r2) {
        super(r1, r2);
    }
}
