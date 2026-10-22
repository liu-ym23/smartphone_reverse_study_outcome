package com.lynx.markdown;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IMarkdownViewHandle {
    void align(int r1, int r2);

    long getPosition();

    long getSize();

    int getVerticalAlign();

    long measure(int r1, int r2, int r3, int r4);

    void requestAlign();

    void requestDraw();

    void requestMeasure();

    void setPosition(int r1, int r2);

    void setSize(int r1, int r2);

    void setVisibility(boolean r1);
}
