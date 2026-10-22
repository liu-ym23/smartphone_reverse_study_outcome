package com.ss.android.lark.feed.shared.page.swipe;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SwipeActionTextHelper {
    public static final float c = 0.0f;
    public final ArrayList<a> a;
    public final ArrayList<a> b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/swipe/SwipeActionTextHelper$Mode;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "START_WIDTH_14", "START_WIDTH_12", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Mode extends Enum<Mode> {
        public static final Mode START_WIDTH_12 = null;
        public static final Mode START_WIDTH_14 = null;
        public static final /* synthetic */ Mode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Mode> getEntries() {
            return b;
        }

        static {
            Mode r0 = new Mode("START_WIDTH_14", 0);
            START_WIDTH_14 = r0;
            Mode r1 = new Mode("START_WIDTH_12", 1);
            START_WIDTH_12 = r1;
            Mode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Mode[] values() {
            return (Mode[]) a.clone();
        }

        public static Mode valueOf(String r1) {
            return (Mode) r27.a.a(Mode.class, r1);
        }

        public Mode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
    }

    public static final class b {
    }

    static {
        zz7.b.j(14);
        c = zz7.b.j(12);
        zz7.b.j(10);
    }

    public SwipeActionTextHelper() {
        this.a = CollectionsKt.arrayListOf(new a[]{new e(), new f(), new g(), new h(), new i()});
        this.b = CollectionsKt.arrayListOf(new a[]{new com.ss.android.lark.feed.shared.page.swipe.a(), new com.ss.android.lark.feed.shared.page.swipe.b(), new c(), new d()});
    }
}
