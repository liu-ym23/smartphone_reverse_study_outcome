package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/assistant/cocreationreview/MainView;", NameKeys.UnloadStrategy_No_Strategy, "title", NameKeys.UnloadStrategy_No_Strategy, "dockLabel", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getDockLabel", "OVERVIEW", "REVIEW", "TASK_CENTER", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MainView extends Enum<MainView> {
    public static final MainView OVERVIEW = null;
    public static final MainView REVIEW = null;
    public static final MainView TASK_CENTER = null;
    public static final /* synthetic */ MainView[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String dockLabel;
    private final String title;

    public static EnumEntries<MainView> getEntries() {
        return b;
    }

    static {
        MainView r0 = new MainView("OVERVIEW", 0, "数据总览", "总览");
        OVERVIEW = r0;
        MainView r1 = new MainView("REVIEW", 1, "共创评测", "评测");
        REVIEW = r1;
        MainView r2 = new MainView("TASK_CENTER", 2, "任务中心", "任务");
        TASK_CENTER = r2;
        MainView[] r3 = {r0, r1, r2};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MainView[] values() {
        return (MainView[]) a.clone();
    }

    public final String getDockLabel() {
        return this.dockLabel;
    }

    public final String getTitle() {
        return this.title;
    }

    public static MainView valueOf(String r1) {
        return (MainView) r27.a.a(MainView.class, r1);
    }

    public MainView(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.title = r3;
        this.dockLabel = r4;
    }
}
