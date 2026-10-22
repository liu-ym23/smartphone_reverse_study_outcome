package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedVCHardwareStatusComponent extends FeedCardComponent<Object, FeedVCStatusIconView> {
    public final Context c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/FeedVCHardwareStatusComponent$HardwareStatusMode;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Connected", "Upload", "Recording", "Paused", "Summarizing", "Gone", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum HardwareStatusMode extends Enum<HardwareStatusMode> {
        public static final HardwareStatusMode Connected = null;
        public static final HardwareStatusMode Gone = null;
        public static final HardwareStatusMode Paused = null;
        public static final HardwareStatusMode Recording = null;
        public static final HardwareStatusMode Summarizing = null;
        public static final HardwareStatusMode Upload = null;
        public static final /* synthetic */ HardwareStatusMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<HardwareStatusMode> getEntries() {
            return b;
        }

        static {
            HardwareStatusMode r0 = new HardwareStatusMode("Connected", 0);
            Connected = r0;
            HardwareStatusMode r1 = new HardwareStatusMode("Upload", 1);
            Upload = r1;
            HardwareStatusMode r3 = new HardwareStatusMode("Recording", 2);
            Recording = r3;
            HardwareStatusMode r5 = new HardwareStatusMode("Paused", 3);
            Paused = r5;
            HardwareStatusMode r7 = new HardwareStatusMode("Summarizing", 4);
            Summarizing = r7;
            HardwareStatusMode r9 = new HardwareStatusMode("Gone", 5);
            Gone = r9;
            HardwareStatusMode[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static HardwareStatusMode[] values() {
            return (HardwareStatusMode[]) a.clone();
        }

        public static HardwareStatusMode valueOf(String r1) {
            return (HardwareStatusMode) r27.a.a(HardwareStatusMode.class, r1);
        }

        public HardwareStatusMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        return new FeedVCStatusIconView(getContext(), null);
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -2);
        r0.gravity = 16;
        return r0;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public Context getContext() {
        return this.c;
    }

    public FeedVCHardwareStatusComponent(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = r2;
    }
}
