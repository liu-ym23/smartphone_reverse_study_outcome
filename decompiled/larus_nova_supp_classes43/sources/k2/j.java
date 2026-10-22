package k2;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface j extends i, p, k {
    void doRefresh();

    AppletRuntime getAppletRuntime();

    t getFloatingSpeakerController();

    PageInfo getPageInfo();

    void handleContentSizeChange(double r1, double r10);

    void setFloatingSpeakerController(t r1);

    void setUiContext(String r1);

    String viewContext();
}
