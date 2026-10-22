package com.larus.doc.sdk.impl.generalbiz.state.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/model/DocToolbarItemId;", "", "<init>", "()V", "AI_EDIT", "", "getAI_EDIT", "()Ljava/lang/String;", "VOICE_INPUT", "getVOICE_INPUT", "ADJUST_STYLE", "getADJUST_STYLE", "FILE_INSERT", "getFILE_INSERT", "ALL", "getALL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocToolbarItemId {
    private static final String ADJUST_STYLE = null;
    private static final String AI_EDIT = null;
    private static final String ALL = null;
    private static final String FILE_INSERT = null;
    public static final DocToolbarItemId INSTANCE = null;
    private static final String VOICE_INPUT = null;

    private DocToolbarItemId() {
    }

    static {
        INSTANCE = new DocToolbarItemId();
        AI_EDIT = "ai_edit";
        VOICE_INPUT = "voice_input";
        ADJUST_STYLE = "adjust_style";
        FILE_INSERT = "file_insert";
        ALL = "all";
    }

    public final String getADJUST_STYLE() {
        return ADJUST_STYLE;
    }

    public final String getAI_EDIT() {
        return AI_EDIT;
    }

    public final String getALL() {
        return ALL;
    }

    public final String getFILE_INSERT() {
        return FILE_INSERT;
    }

    public final String getVOICE_INPUT() {
        return VOICE_INPUT;
    }
}
