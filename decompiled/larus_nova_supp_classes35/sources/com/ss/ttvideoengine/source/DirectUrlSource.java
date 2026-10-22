package com.ss.ttvideoengine.source;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DirectUrlSource implements StrategySource {
    public static final int KEY_LITE_EDITION = 1;
    private static final int KEY_PRO_EDITION = 2;
    private final int codecStrategy;
    private final boolean smartUrlEnabled;
    private final int smartUrlVersion;
    private final Object tag;
    private final List<UrlItem> urlItems;
    private final String vid;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.source.DirectUrlSource$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private int codecStrategy;
        private final List<UrlItem> items;
        private boolean smartUrlEnabled;
        private int smartUrlVersion;
        private Object tag;
        private String vid;

        public DirectUrlSource build() {
            if (this.items.isEmpty() == true) goto L7;
            return new DirectUrlSource(this, null);
        L7:
            throw new IllegalArgumentException("items is empty");
        }

        public Builder() {
            this.items = new ArrayList();
            this.smartUrlVersion = 1;
        }

        public static /* synthetic */ String access$000(Builder r0) {
            return r0.vid;
        }

        public static /* synthetic */ List access$100(Builder r0) {
            return r0.items;
        }

        public static /* synthetic */ int access$200(Builder r0) {
            return r0.codecStrategy;
        }

        public static /* synthetic */ boolean access$300(Builder r0) {
            return r0.smartUrlEnabled;
        }

        public static /* synthetic */ int access$400(Builder r0) {
            return r0.smartUrlVersion;
        }

        public static /* synthetic */ Object access$500(Builder r0) {
            return r0.tag;
        }

        public Builder addItem(UrlItem r2) {
            if (r2 == null) goto L6;
            this.items.add(r2);
            return this;
        L6:
            throw new NullPointerException("urlItem = null");
        }

        public Builder setCodecStrategy(int r1) {
            this.codecStrategy = r1;
            return this;
        }

        public Builder setSmartUrlEnabled(boolean r1) {
            this.smartUrlEnabled = r1;
            return this;
        }

        public Builder setSmartUrlVersion(int r1) {
            this.smartUrlVersion = r1;
            return this;
        }

        public Builder setTag(Object r1) {
            this.tag = r1;
            return this;
        }

        public Builder setVid(String r1) {
            this.vid = r1;
            return this;
        }
    }

    public static class UrlItem {
        private final int bitrate;
        private final String cacheKey;
        private final String encodeType;
        private final String format;
        private final String playAuth;
        private final long urlExpiredTime;
        private final String[] urlExpires;
        private final String[] urls;

        public static class Builder {
            private int bitrate;
            private String cacheKey;
            private String encodeType;
            private String format;
            private String playAuth;
            private long urlExpiredTime;
            private String[] urlExpires;
            private String[] urls;

            public UrlItem build() {
                checkUrls(this.urls);
                return new UrlItem(this, null);
            }

            public Builder() {
                this.bitrate = -1;
            }

            public Builder(UrlItem r3) {
                this.bitrate = -1;
                this.urls = UrlItem.access$1500(r3);
                this.urlExpires = UrlItem.access$1600(r3);
                this.urlExpiredTime = UrlItem.access$1700(r3);
                this.cacheKey = UrlItem.access$1800(r3);
                this.playAuth = UrlItem.access$1900(r3);
                this.encodeType = UrlItem.access$600(r3);
                this.format = UrlItem.access$2000(r3);
                this.bitrate = UrlItem.access$2100(r3);
            }

            public static /* synthetic */ String access$1000(Builder r0) {
                return r0.cacheKey;
            }

            public static /* synthetic */ String access$1100(Builder r0) {
                return r0.playAuth;
            }

            public static /* synthetic */ String access$1200(Builder r0) {
                return r0.encodeType;
            }

            public static /* synthetic */ String access$1300(Builder r0) {
                return r0.format;
            }

            public static /* synthetic */ int access$1400(Builder r0) {
                return r0.bitrate;
            }

            public static /* synthetic */ String[] access$700(Builder r0) {
                return r0.urls;
            }

            public static /* synthetic */ String[] access$800(Builder r0) {
                return r0.urlExpires;
            }

            public static /* synthetic */ long access$900(Builder r2) {
                return r2.urlExpiredTime;
            }

            private static void checkUrls(String[] r1) {
                if (r1 == null) goto L13;
                if (r1.length == 0) goto L11;
                if (TextUtils.isEmpty(r1[0]) == true) goto L9;
                return;
            L9:
                throw new IllegalArgumentException("urls[0] = null");
            L11:
                throw new IllegalArgumentException("urls is empty");
            L13:
                throw new NullPointerException("urls = null");
            }

            public Builder setBitrate(int r1) {
                this.bitrate = r1;
                return this;
            }

            public Builder setCacheKey(String r1) {
                this.cacheKey = r1;
                return this;
            }

            public Builder setEncodeType(String r1) {
                this.encodeType = r1;
                return this;
            }

            public Builder setFormat(String r1) {
                this.format = r1;
                return this;
            }

            public Builder setPlayAuth(String r1) {
                this.playAuth = r1;
                return this;
            }

            public Builder setUrl(String r3) {
                if (r3 == null) goto L6;
                this.urls = new String[]{r3};
                return this;
            L6:
                throw new NullPointerException("url = null");
            }

            public Builder setUrlExpire(String r3) {
                if (r3 == null) goto L6;
                this.urlExpires = new String[]{r3};
                return this;
            L6:
                throw new NullPointerException("expire = null");
            }

            public Builder setUrlExpiredTime(long r1) {
                this.urlExpiredTime = r1;
                return this;
            }

            public Builder setUrlExpires(String[] r1) {
                this.urlExpires = r1;
                return this;
            }

            public Builder setUrls(String[] r1) {
                checkUrls(r1);
                this.urls = r1;
                return this;
            }
        }

        public String getUrl() {
            return this.urls[0];
        }

        public String getUrlExpire() {
            String[] r0 = this.urlExpires;
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0[0];
        }

        public String toString() {
            return "UrlItem{urls=" + Arrays.toString(this.urls) + ", urlExpires=" + Arrays.toString(this.urlExpires) + ", urlExpiredTime=" + this.urlExpiredTime + ", cacheKey='" + this.cacheKey + "', playAuth='" + this.playAuth + "', encodeType='" + this.encodeType + "', format='" + this.format + "', bitrate=" + this.bitrate + '}';
        }

        public int getBitrate() {
            return this.bitrate;
        }

        public String getCacheKey() {
            return this.cacheKey;
        }

        public String getEncodeType() {
            return this.encodeType;
        }

        public String getFormat() {
            return this.format;
        }

        public String getPlayAuth() {
            return this.playAuth;
        }

        public long getUrlExpiredTime() {
            return this.urlExpiredTime;
        }

        public String[] getUrlExpires() {
            return this.urlExpires;
        }

        public String[] getUrls() {
            return this.urls;
        }

        private UrlItem(Builder r3) {
            Builder.access$700(r3);
            this.urls = Builder.access$700(r3);
            this.urlExpires = Builder.access$800(r3);
            this.urlExpiredTime = Builder.access$900(r3);
            this.cacheKey = Builder.access$1000(r3);
            this.playAuth = Builder.access$1100(r3);
            this.encodeType = Builder.access$1200(r3);
            this.format = Builder.access$1300(r3);
            this.bitrate = Builder.access$1400(r3);
        }

        public static /* synthetic */ String[] access$1500(UrlItem r0) {
            return r0.urls;
        }

        public static /* synthetic */ String[] access$1600(UrlItem r0) {
            return r0.urlExpires;
        }

        public static /* synthetic */ long access$1700(UrlItem r2) {
            return r2.urlExpiredTime;
        }

        public static /* synthetic */ String access$1800(UrlItem r0) {
            return r0.cacheKey;
        }

        public static /* synthetic */ String access$1900(UrlItem r0) {
            return r0.playAuth;
        }

        public static /* synthetic */ String access$2000(UrlItem r0) {
            return r0.format;
        }

        public static /* synthetic */ int access$2100(UrlItem r0) {
            return r0.bitrate;
        }

        public static /* synthetic */ String access$600(UrlItem r0) {
            return r0.encodeType;
        }

        public /* synthetic */ UrlItem(Builder r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    @Override // com.ss.ttvideoengine.source.Source
    public final /* synthetic */ boolean isCodecStrategyValid() {
        return Source.CC.$default$isCodecStrategyValid(this);
    }

    public List<UrlItem> allItems() {
        return Collections.unmodifiableList(this.urlItems);
    }

    public UrlItem firstItem() {
        if (this.urlItems.isEmpty() == false) goto L6;
        return null;
    L6:
        return (UrlItem) ListProtector.get(this.urlItems, 0);
    }

    public boolean isEmpty() {
        return this.urlItems.isEmpty();
    }

    public boolean isSmartUrlValid() {
        if (this.smartUrlEnabled == false) goto L8;
        int r0 = this.smartUrlVersion;
        if (r0 == 2) goto L10;
        if (r0 != 1) goto L8;
        return true;
    L10:
        return true;
    L8:
        return false;
    }

    public String toString() {
        return "DirectUrlSource{vid='" + this.vid + "', urlItems=" + this.urlItems + ", codecStrategy=" + this.codecStrategy + ", smartUrlEnabled=" + this.smartUrlEnabled + ", smartUrlVersion=" + this.smartUrlVersion + '}';
    }

    @Override // com.ss.ttvideoengine.source.Source
    public int codecStrategy() {
        return this.codecStrategy;
    }

    public boolean isSmartUrlEnabled() {
        return this.smartUrlEnabled;
    }

    public int smartUrlVersion() {
        return this.smartUrlVersion;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public Object tag() {
        return this.tag;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public Source.Type type() {
        return Source.Type.DIRECT_URL_SOURCE;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public String vid() {
        return this.vid;
    }

    private DirectUrlSource(Builder r3) {
        ArrayList r0 = new ArrayList();
        this.urlItems = r0;
        if (Builder.access$000(r3) != null) goto L5;
        String r1 = UUID.randomUUID().toString();
    L6:
        this.vid = r1;
        r0.addAll(Builder.access$100(r3));
        this.codecStrategy = Builder.access$200(r3);
        this.smartUrlEnabled = Builder.access$300(r3);
        this.smartUrlVersion = Builder.access$400(r3);
        this.tag = Builder.access$500(r3);
        return;
    L5:
        r1 = Builder.access$000(r3);
        goto L6
    }

    public UrlItem findItemByEncodeType(String r4) {
        Iterator<UrlItem> r0 = this.urlItems.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        UrlItem r1 = r0.next();
        if (TextUtils.equals(UrlItem.access$600(r1), r4) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    public /* synthetic */ DirectUrlSource(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }
}
