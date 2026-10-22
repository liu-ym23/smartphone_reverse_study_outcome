package com.larus.doc.sdk.impl.generalbiz.rewrite;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/rewrite/SelectChangeData;", "", "<init>", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "plainText", "getPlainText", "setPlainText", "wholeText", "getWholeText", "setWholeText", "type", "", "getType", "()I", "setType", "(I)V", "cursorPosition", "Lcom/larus/doc/sdk/impl/generalbiz/rewrite/PositionPoint;", "getCursorPosition", "()Lcom/larus/doc/sdk/impl/generalbiz/rewrite/PositionPoint;", "setCursorPosition", "(Lcom/larus/doc/sdk/impl/generalbiz/rewrite/PositionPoint;)V", "selectedContent", "Lcom/larus/doc/sdk/impl/generalbiz/rewrite/SelectedContent;", "getSelectedContent", "()Lcom/larus/doc/sdk/impl/generalbiz/rewrite/SelectedContent;", "setSelectedContent", "(Lcom/larus/doc/sdk/impl/generalbiz/rewrite/SelectedContent;)V", "docStructureVersion", "getDocStructureVersion", "()Ljava/lang/Integer;", "setDocStructureVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectChangeData {

    @SerializedName("cursorPosition")
    private PositionPoint cursorPosition;

    @SerializedName("docStructureVersion")
    private Integer docStructureVersion;

    @SerializedName("plainText")
    private String plainText;

    @SerializedName("selectedContent")
    private SelectedContent selectedContent;

    @SerializedName("text")
    private String text;

    @SerializedName("type")
    private int type;

    @SerializedName("wholeText")
    private String wholeText;

    public SelectChangeData() {
    }

    public final PositionPoint getCursorPosition() {
        return this.cursorPosition;
    }

    public final Integer getDocStructureVersion() {
        return this.docStructureVersion;
    }

    public final String getPlainText() {
        return this.plainText;
    }

    public final SelectedContent getSelectedContent() {
        return this.selectedContent;
    }

    public final String getText() {
        return this.text;
    }

    public final int getType() {
        return this.type;
    }

    public final String getWholeText() {
        return this.wholeText;
    }

    public final void setCursorPosition(PositionPoint r1) {
        this.cursorPosition = r1;
    }

    public final void setDocStructureVersion(Integer r1) {
        this.docStructureVersion = r1;
    }

    public final void setPlainText(String r1) {
        this.plainText = r1;
    }

    public final void setSelectedContent(SelectedContent r1) {
        this.selectedContent = r1;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final void setWholeText(String r1) {
        this.wholeText = r1;
    }
}
