package com.bytedance.android.live.base.model.user;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ProfileText {

    @SerializedName("pieces")
    List<ProfileTextPiece> pieces;

    public ProfileText() {
    }

    public int imagePiecesCount() {
        int r1 = 0;
        if (this.pieces == null) goto L12;
        int r0 = 0;
    L6:
        if (r1 >= this.pieces.size()) goto L11;
        if (((ProfileTextPiece) ListProtector.get(this.pieces, r1)).type != ProfileTextPiece.PIECE_TYPE_IMAGE) goto L10;
        r0 = r0 + 1;
    L10:
        r1 = r1 + 1;
        goto L6
    L11:
        return r0;
    L12:
        return 0;
    }

    public List<ProfileTextPiece> getPieces() {
        return this.pieces;
    }

    public void setPieces(List<ProfileTextPiece> r1) {
        this.pieces = r1;
    }
}
