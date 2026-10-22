package xh0;

import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {
    boolean beforeOpen();

    ArrayList<f> getIncompatibleSourceList();

    ArrayList<Integer> getOverlayWhiteList();

    h getPlayModeInfo();

    g isCanOpen(HashMap<String, Object> r1);

    boolean isOpen();

    Pair<Boolean, String> isSupportSceneChange(int r1);

    Pair<Boolean, String> isSupportUiLayoutChang(int r1);

    void tryStartPlayMode(HashMap<String, Object> r1);

    void tryStopPlayMode(HashMap<String, Object> r1);
}
