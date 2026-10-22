package db0;

import cb0.c;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a {
    Observable<c> findMidiSegment(long r1);

    c findMidiSegmentOpt(long r1);

    Single<List<c>> findMidiSegments(long r1, long r3);

    List<c> findMidiSegmentsOpt(long r1, long r3);
}
