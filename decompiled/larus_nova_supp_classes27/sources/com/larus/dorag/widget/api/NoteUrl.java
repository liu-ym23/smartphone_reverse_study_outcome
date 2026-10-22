package com.larus.dorag.widget.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/dorag/widget/api/NoteUrl;", "Ljava/io/Serializable;", "<init>", "()V", "noteUrl", "", "getNoteUrl", "()Ljava/lang/String;", "setNoteUrl", "(Ljava/lang/String;)V", "dorag_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoteUrl implements Serializable {

    @SerializedName("url")
    private String noteUrl;

    public NoteUrl() {
    }

    public final String getNoteUrl() {
        return this.noteUrl;
    }

    public final void setNoteUrl(String r1) {
        this.noteUrl = r1;
    }
}
