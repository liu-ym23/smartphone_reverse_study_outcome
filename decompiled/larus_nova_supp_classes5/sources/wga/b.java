package wga;

import com.obric.assistant.spi.window.WindowOpenSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface b {
    void onScreenRotationChanged(int r1, int r2);

    void onWindowDismissed();

    void onWindowOpened(WindowOpenSource r1);

    void onWindowPreDismissed();

    void onWindowPreOpenClear();

    void onWindowPreOpened(WindowOpenSource r1);

    void onWindowPreStashed();

    void onWindowStashed();
}
