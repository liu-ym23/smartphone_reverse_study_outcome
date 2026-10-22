package androidx.room.jarjarred.org.antlr.v4.runtime.tree.pattern;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MultiMap;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import com.bytedance.ai.event.MessageIndication;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ParseTreeMatch {
    private final MultiMap<String, ParseTree> labels;
    private final ParseTree mismatchedNode;
    private final ParseTreePattern pattern;
    private final ParseTree tree;

    public ParseTreeMatch(ParseTree r5, ParseTreePattern r10, MultiMap<String, ParseTree> r11, ParseTree r12) {
        if (r5 == null) goto L13;
        if (r10 == null) goto L11;
        if (r11 == null) goto L9;
        this.tree = r5;
        this.pattern = r10;
        this.labels = r11;
        this.mismatchedNode = r12;
        return;
    L9:
        throw new IllegalArgumentException("labels cannot be null");
    L11:
        throw new IllegalArgumentException("pattern cannot be null");
    L13:
        throw new IllegalArgumentException("tree cannot be null");
    }

    public ParseTree get(String r5) {
        List r10 = (List) this.labels.get(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.size() != 0) goto L8;
        return null;
    L8:
        return (ParseTree) j0.e(r10, 1);
    }

    public List<ParseTree> getAll(String r5) {
        List<ParseTree> r10 = (List) this.labels.get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Collections.emptyList();
    }

    public MultiMap<String, ParseTree> getLabels() {
        return this.labels;
    }

    public ParseTree getMismatchedNode() {
        return this.mismatchedNode;
    }

    public ParseTreePattern getPattern() {
        return this.pattern;
    }

    public ParseTree getTree() {
        return this.tree;
    }

    public boolean succeeded() {
        if (this.mismatchedNode != null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (succeeded() == false) goto L5;
        String r5 = "succeeded";
    L7:
        return String.format("Match %s; found %d labels", new Object[]{r5, Integer.valueOf(getLabels().size())});
    L5:
        r5 = MessageIndication.STATUS_FAILED;
        goto L7
    }
}
