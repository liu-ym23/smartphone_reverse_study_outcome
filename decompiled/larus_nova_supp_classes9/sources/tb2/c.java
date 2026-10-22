package tb2;

import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.e5;
import com.bytedance.android.live.base.model.message.f5;
import com.bytedance.android.live.base.model.message.g5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.user.h0;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements c5 {
    public static final a Companion = null;
    public static final String DEFAULT_TEXT = "  ";
    public static final String IMAGE_DEFAULT_TEXT = "* ";
    private h0 badge;
    private List<c> bindUserBadgePieceList;
    private b clickAction;
    private m6 convertedSchema;
    private Integer imageDefaultRes;
    private boolean isBadgePiece;
    private String text;
    private int textIndex;
    private c5 tp;
    private int verticalOffset;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public b5 getFormat() {
        c5 r0 = this.tp;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFormat();
    }

    public e5 getGiftValue() {
        c5 r0 = this.tp;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getGiftValue();
    }

    public f5 getHeartValue() {
        c5 r0 = this.tp;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHeartValue();
    }

    public ITextPieceImage getImageValue() {
        c5 r0 = this.tp;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getImageValue();
    }

    public g5 getPatternRefValue() {
        c5 r0 = this.tp;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPatternRefValue();
    }

    public String getRefKey() {
        c5 r0 = this.tp;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRefKey();
    }

    public String getSchemaKey() {
        c5 r0 = this.tp;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSchemaKey();
    }

    public String getStringValue() {
        c5 r0 = this.tp;
        if (r0 == null) goto L6;
        String r1 = r0.getStringValue();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return BuildConfig.FLAVOR;
    }

    public int getType() {
        c5 r0 = this.tp;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getType();
    }

    public i5 getUserValue() {
        c5 r0 = this.tp;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getUserValue();
    }

    public boolean isNormalPiece() {
        c5 r0 = this.tp;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isNormalPiece();
    }

    public String toString() {
        return "RenderPiece(textIndex=" + this.textIndex + ", text='" + getText() + "', super = " + super.toString() + ')';
    }

    public final String getText() {
        if (getType() != PieceType.IMAGE.getPieceType()) goto L9;
        if (StringsKt.isBlank(this.text) == false) goto L9;
        return IMAGE_DEFAULT_TEXT;
    L9:
        return this.text;
    }

    public final h0 getBadge() {
        return this.badge;
    }

    public final List<c> getBindUserBadgePieceList() {
        return this.bindUserBadgePieceList;
    }

    public final b getClickAction() {
        return this.clickAction;
    }

    public final m6 getConvertedSchema() {
        return this.convertedSchema;
    }

    public final Integer getImageDefaultRes() {
        return this.imageDefaultRes;
    }

    public final int getTextIndex() {
        return this.textIndex;
    }

    public final c5 getTp() {
        return this.tp;
    }

    public final int getVerticalOffset() {
        return this.verticalOffset;
    }

    public final boolean isBadgePiece() {
        return this.isBadgePiece;
    }

    public c(c5 r2) {
        this.textIndex = -1;
        this.text = DEFAULT_TEXT;
        this.tp = r2;
    }

    public <R extends vh7.e<c5>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        throw new UnsupportedOperationException();
    }

    public <R extends vh7.e<c5>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        throw new UnsupportedOperationException();
    }

    public final void setBadge(h0 r1) {
        this.badge = r1;
    }

    public final void setBadgePiece(boolean r1) {
        this.isBadgePiece = r1;
    }

    public final void setBindUserBadgePieceList(List<c> r1) {
        this.bindUserBadgePieceList = r1;
    }

    public final c setClickAction(b r1) {
        this.clickAction = r1;
        return this;
    }

    public final void setConvertedSchema(m6 r1) {
        this.convertedSchema = r1;
    }

    public void setFormat(b5 r2) {
        c5 r0 = this.tp;
        if (r0 == null) goto L6;
        r0.setFormat(r2);
        return;
    }

    public void setGiftValue(e5 r2) {
        c5 r0 = this.tp;
        if (r0 == null) goto L6;
        r0.setGiftValue(r2);
        return;
    }

    public void setHeartValue(f5 r2) {
        c5 r0 = this.tp;
        if (r0 == null) goto L6;
        r0.setHeartValue(r2);
        return;
    }

    public final void setImageDefaultRes(Integer r1) {
        this.imageDefaultRes = r1;
    }

    public void setImageValue(ITextPieceImage r2) {
        c5 r0 = this.tp;
        if (r0 == null) goto L6;
        r0.setImageValue(r2);
        return;
    }

    public void setNormalPiece(boolean r2) {
        c5 r0 = this.tp;
        if (r0 == null) goto L6;
        r0.setNormalPiece(r2);
        return;
    }

    public void setPatternRefValue(g5 r2) {
        c5 r0 = this.tp;
        if (r0 == null) goto L6;
        r0.setPatternRefValue(r2);
        return;
    }

    public void setRefKey(String r2) {
        c5 r0 = this.tp;
        if (r0 == null) goto L6;
        r0.setRefKey(r2);
        return;
    }

    public void setSchemaKey(String r2) {
        c5 r0 = this.tp;
        if (r0 == null) goto L6;
        r0.setSchemaKey(r2);
        return;
    }

    public void setStringValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        c5 r0 = this.tp;
        if (r0 == null) goto L6;
        r0.setStringValue(r2);
        return;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.text = r2;
    }

    public final void setTextIndex(int r1) {
        this.textIndex = r1;
    }

    public final void setTp(c5 r1) {
        this.tp = r1;
    }

    public void setType(int r2) {
        c5 r0 = this.tp;
        if (r0 == null) goto L6;
        r0.setType(r2);
        return;
    }

    public void setUserValue(i5 r2) {
        c5 r0 = this.tp;
        if (r0 == null) goto L6;
        r0.setUserValue(r2);
        return;
    }

    public final void setVerticalOffset(int r1) {
        this.verticalOffset = r1;
    }

    public c(c5 r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        this(r2);
        this.text = r3;
    }
}
