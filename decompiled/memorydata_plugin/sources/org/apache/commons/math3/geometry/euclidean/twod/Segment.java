package org.apache.commons.math3.geometry.euclidean.twod;

/* JADX INFO: loaded from: classes6.dex */
public class Segment {
    private final Vector2D end;
    private final Line line;
    private final Vector2D start;

    public Segment(Vector2D r1, Vector2D r2, Line r3) {
        this.start = r1;
        this.end = r2;
        this.line = r3;
    }

    public Line getLine() {
        return this.line;
    }
}
