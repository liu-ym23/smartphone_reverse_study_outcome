package p7a;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface a {
    boolean canConsumeGesture(float r1, float r2);

    int getGestureArenaMemberId();

    Map<Integer, s7a.a> getGestureDetectorMap();

    Map<Integer, t7a.a> getGestureHandlers();

    int getMemberScrollX();

    int getMemberScrollY();

    int getScrollContainerDirection();

    int getSign();

    boolean isAtBorder(boolean r1);

    void onGestureScrollBy(float r1, float r2);

    void onInvalidate();

    void onPlatformGestureStatusChanged(int r1);
}
