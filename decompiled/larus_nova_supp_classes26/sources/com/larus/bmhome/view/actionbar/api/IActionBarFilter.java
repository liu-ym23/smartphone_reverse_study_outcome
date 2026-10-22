package com.larus.bmhome.view.actionbar.api;

import com.larus.bmhome.actionbar.model.z0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import ss8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface IActionBarFilter {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/view/actionbar/api/IActionBarFilter$FilterMode;", "", "<init>", "(Ljava/lang/String;I)V", "BLACKLIST", "WHITELIST", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FilterMode extends Enum<FilterMode> {
        public static final FilterMode BLACKLIST = null;
        public static final FilterMode WHITELIST = null;
        public static final /* synthetic */ FilterMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<FilterMode> getEntries() {
            return b;
        }

        static {
            FilterMode r0 = new FilterMode("BLACKLIST", 0);
            BLACKLIST = r0;
            FilterMode r1 = new FilterMode("WHITELIST", 1);
            WHITELIST = r1;
            FilterMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static FilterMode[] values() {
            return (FilterMode[]) a.clone();
        }

        public static FilterMode valueOf(String r1) {
            return (FilterMode) r27.a.a(FilterMode.class, r1);
        }

        public FilterMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    boolean a(z0 r1, d r2);

    String b();

    FilterMode getMode();

    int getPriority();
}
