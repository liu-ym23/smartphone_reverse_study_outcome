package org.apache.poi.hwpf.usermodel;

import java.util.List;
import java.util.Map;
import org.apache.poi.hwpf.model.BookmarksTables;
import org.apache.poi.hwpf.model.GenericPropertyNode;

/* JADX INFO: loaded from: classes7.dex */
public class BookmarksImpl implements Bookmarks {
    private final BookmarksTables bookmarksTables;
    private Map<Integer, List<GenericPropertyNode>> sortedDescriptors;
    private int[] sortedStartPositions;

    public BookmarksImpl(BookmarksTables r1) {
        this.bookmarksTables = r1;
        reset();
    }

    private void reset() {
        this.sortedDescriptors = null;
        this.sortedStartPositions = null;
    }

    void afterDelete(int r2, int r3) {
        this.bookmarksTables.afterDelete(r2, r3);
        reset();
    }
}
