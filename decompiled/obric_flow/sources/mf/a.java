package mf;

import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.map.api.model.IMarker;
import com.lynx.react.bridge.ReadableMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    IMarker addMarker(BDMarkerOptions r5, boolean r10);

    BDMarkerOptions genMarkerOptions(ReadableMap r5, float r10, float r11, boolean r12);

    List parseAnimationStyle(ReadableMap r5);

    void removeMarker(IMarker r5, boolean r10);

    void startMarkerAnimation(IMarker r5, List r10);
}
