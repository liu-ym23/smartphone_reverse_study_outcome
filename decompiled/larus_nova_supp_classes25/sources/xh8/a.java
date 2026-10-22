package xh8;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements Cursor {
    public a() {
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // android.database.Cursor
    public final void copyStringToBuffer(int r1, CharArrayBuffer r2) {
    }

    @Override // android.database.Cursor
    public final void deactivate() {
    }

    @Override // android.database.Cursor
    public final byte[] getBlob(int r1) {
        return new byte[0];
    }

    @Override // android.database.Cursor
    public final int getColumnCount() {
        return 0;
    }

    @Override // android.database.Cursor
    public final int getColumnIndex(String r1) {
        return 0;
    }

    @Override // android.database.Cursor
    public final int getColumnIndexOrThrow(String r1) throws IllegalArgumentException {
        return 0;
    }

    @Override // android.database.Cursor
    public final String getColumnName(int r1) {
        return null;
    }

    @Override // android.database.Cursor
    public final String[] getColumnNames() {
        return new String[0];
    }

    @Override // android.database.Cursor
    public final int getCount() {
        return 0;
    }

    @Override // android.database.Cursor
    public final double getDouble(int r3) {
        return 0.0d;
    }

    @Override // android.database.Cursor
    public final Bundle getExtras() {
        return null;
    }

    @Override // android.database.Cursor
    public final float getFloat(int r1) {
        return 0.0f;
    }

    @Override // android.database.Cursor
    public final int getInt(int r1) {
        return 0;
    }

    @Override // android.database.Cursor
    public final long getLong(int r3) {
        return 0;
    }

    @Override // android.database.Cursor
    public final Uri getNotificationUri() {
        return null;
    }

    @Override // android.database.Cursor
    public final int getPosition() {
        return 0;
    }

    @Override // android.database.Cursor
    public final short getShort(int r1) {
        return 0;
    }

    @Override // android.database.Cursor
    public final String getString(int r1) {
        return null;
    }

    @Override // android.database.Cursor
    public int getType(int r1) {
        return 0;
    }

    @Override // android.database.Cursor
    public final boolean getWantsAllOnMoveCalls() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isAfterLast() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isBeforeFirst() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isClosed() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isFirst() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isLast() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isNull(int r1) {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean move(int r1) {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToFirst() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToLast() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToNext() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToPosition(int r1) {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToPrevious() {
        return false;
    }

    @Override // android.database.Cursor
    public final void registerContentObserver(ContentObserver r1) {
    }

    @Override // android.database.Cursor
    public final void registerDataSetObserver(DataSetObserver r1) {
    }

    @Override // android.database.Cursor
    public final boolean requery() {
        return false;
    }

    @Override // android.database.Cursor
    public final Bundle respond(Bundle r1) {
        return null;
    }

    @Override // android.database.Cursor
    public final void setExtras(Bundle r1) {
    }

    @Override // android.database.Cursor
    public final void setNotificationUri(ContentResolver r1, Uri r2) {
    }

    @Override // android.database.Cursor
    public final void unregisterContentObserver(ContentObserver r1) {
    }

    @Override // android.database.Cursor
    public final void unregisterDataSetObserver(DataSetObserver r1) {
    }
}
