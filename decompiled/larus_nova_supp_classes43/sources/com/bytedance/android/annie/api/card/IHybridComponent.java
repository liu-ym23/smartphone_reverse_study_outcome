package com.bytedance.android.annie.api.card;

import android.view.View;
import com.bytedance.android.annie.card.web.WebComponent;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.Metadata;
import y6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IHybridComponent extends a7.b {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/annie/api/card/IHybridComponent$HybridType;", "", "", "toMonitorString", "hybridName", "Ljava/lang/String;", "getHybridName", "()Ljava/lang/String;", "H5", "LYNX", "annie-api_release"}, k = 1, mv = {1, 4, 3})
    public static final enum HybridType extends Enum<HybridType> {
        public static final HybridType H5 = null;
        public static final HybridType LYNX = null;
        public static final /* synthetic */ HybridType[] a = null;
        private final String hybridName;

        public static HybridType valueOf(String r1) {
            return (HybridType) r27.a.a(HybridType.class, r1);
        }

        public static HybridType[] values() {
            return (HybridType[]) a.clone();
        }

        static {
            HybridType r0 = new HybridType("H5", 0, "H5");
            H5 = r0;
            HybridType r1 = new HybridType("LYNX", 1, "Lynx");
            LYNX = r1;
            a = new HybridType[]{r0, r1};
        }

        public final String toMonitorString() {
            if (this != LYNX) goto L5;
            return "lynx";
        L5:
            return "web";
        }

        public final String getHybridName() {
            return this.hybridName;
        }

        public HybridType(String r1, int r10, String r11) {
            super(r1, r10);
            this.hybridName = r11;
        }
    }

    public interface a {
        void onJSBridgeCreated(c r1);
    }

    public interface b {
        void a(WebComponent r1, int r10, int r11, int r12, int r13);
    }

    void addOnPreDrawListener();

    boolean canGoBack();

    void close();

    String containerId();

    String getBizKey();

    Map<String, Long> getExtraPerfInfo();

    View getHybridView();

    void goBack();

    void hide();

    HybridType hybridType();

    boolean isPopup();

    void load(String r1, Map<String, ? extends Object> r10);

    void registerMethod(String r1, f.b r10);

    <P, R> void registerMethod(String r1, g<P, R> r10);

    void release();

    <T> void sendJsEvent(String r1, T r10);

    void setJSBridgeListener(a r1);

    void setOnScrollChangeListener(b r1);

    void show();

    void updateData(Map<String, ? extends Object> r1);

    void updateGlobalProps(Map<String, ? extends Object> r1);
}
