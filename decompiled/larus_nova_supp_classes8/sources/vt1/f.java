package vt1;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lvt1/f;", "", "", "content", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lvt1/b;", "Lkotlin/collections/ArrayList;", "highlightPositions", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "Lvt1/h;", "wordRecord", "Lvt1/h;", "c", "()Lvt1/h;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("content")
    private final String content;

    @SerializedName("pos")
    private final ArrayList<b> highlightPositions;

    @SerializedName("word_record")
    private final h wordRecord;

    public f() {
        this.content = null;
        this.highlightPositions = null;
        this.wordRecord = null;
    }

    public final String a() {
        return this.content;
    }

    public final ArrayList<b> b() {
        return this.highlightPositions;
    }

    public final h c() {
        return this.wordRecord;
    }
}
